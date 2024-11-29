package com.wintersupplement;

import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {
    public static void main(String[] args) throws MqttException {
        String topicId = System.getenv("TOPIC_ID");
        
        MqttClientService mqttClientService = new MqttClientService(topicId);
        mqttClientService.connect();
    }
}