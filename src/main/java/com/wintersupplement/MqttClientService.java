package com.wintersupplement;

import org.eclipse.paho.client.mqttv3.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wintersupplement.model.WinterSupplementInput;
import com.wintersupplement.model.WinterSupplementOutput;

public class MqttClientService {
    private String topicId;
    private IMqttClient client;
    private ObjectMapper objectMapper = new ObjectMapper();

    public MqttClientService(String topicId) {
        this.topicId = topicId;
    }

     public void connect() throws MqttException {
        client = new MqttClient("tcp://test.mosquitto.org:1883", this.topicId);

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        client.connect(options);
        System.out.println("Connected to MQTT broker");

        client.subscribe("BRE/calculateWinterSupplementInput/" + this.topicId, (topic, msg) -> {
            String payload = new String(msg.getPayload());
            System.out.println("Received message: " + payload);

            WinterSupplementInput winterSupplementInput = objectMapper.readValue(payload, WinterSupplementInput.class);
            publishMessage(winterSupplementInput);
        });
        System.out.println("Subscribed to topic: " + this.topicId);
    }

    public void publishMessage(WinterSupplementInput winterSupplementInput) throws MqttException, JsonProcessingException  {
        RuleEngine ruleEngine = new RuleEngine(winterSupplementInput);
        WinterSupplementOutput winterSupplementOutput = ruleEngine.calculateWinterSupplementOutput();
        
        String outputJson = objectMapper.writeValueAsString(winterSupplementOutput);
        MqttMessage msg = new MqttMessage(outputJson.getBytes());
        client.publish("BRE/calculateWinterSupplementOutput/" + this.topicId, msg);
        System.out.println("Published message: " + outputJson);
    }
}
