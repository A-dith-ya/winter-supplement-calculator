package com.wintersupplement;

import org.eclipse.paho.client.mqttv3.MqttException;

public class Main {
    public static void main(String[] args) throws MqttException {
        String topicId = "16f0bc40-2183-40b7-807f-5abb2fff2b53";
        
        MqttClientService mqttClientService = new MqttClientService(topicId);
        mqttClientService.connect();
    }
}