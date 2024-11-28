package com.wintersupplement;

import org.eclipse.paho.client.mqttv3.*;

public class MqttClientService {
    private String topicId;
    private IMqttClient client;

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

        client.subscribe("BRE/calculateWinterSupplementInput/" + this.topicId, (topic, msg) -> {
            System.out.println(new String(msg.getPayload()));
        });
    }
}
