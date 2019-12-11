package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Mqtt_act extends AppCompatActivity {

    static String MQTTHOST = "tcp://tailor.cloudmqtt.com:15940";
    static String USERNAME = "vpawsbbk";
    static String PASSWORD = "RESf9qF2Liy_";
    String topicStr = "libros";
    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt_act);

        //Generar ClientID para establecer conexion
        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), MQTTHOST, clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());

        try {
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected

                    Toast.makeText(getBaseContext(),"Se Ha conectado", Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems

                    Toast.makeText(getBaseContext(),"No se ha establecido la conexion", Toast.LENGTH_LONG).show();

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void Revival(View v)
    {
        String topic = topicStr;
        String message = "Libro1";
        try
        {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void Farenheit(View v)
    {
        String topic = topicStr;
        String message = "Libro2";
        try
        {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void ElAlquimista(View v)
    {
        String topic = topicStr;
        String message = "Libro3";
        try
        {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void ElPoder(View v)
    {
        String topic = topicStr;
        String message = "Libro4";
        try
        {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void ElDespertar(View v)
    {
        String topic = topicStr;
        String message = "Libro5";
        try
        {
            client.publish(topic, message.getBytes(), 0, false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

