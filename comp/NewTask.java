package mq1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class NewTask {

	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("172.20.10.8");
		factory.setPort(5672);
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//			String message = "Hello World!";
			String message = String.join(" ", argv);
//			channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
			channel.basicPublish("", "hello", null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
		}
	}
}