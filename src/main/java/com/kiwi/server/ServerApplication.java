package com.kiwi.server;

import com.kiwi.server.models.EventModel;
import com.kiwi.server.repositories.EventRepository;
import com.kiwi.server.repositories.UserEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.awt.*;

@SpringBootApplication
public class ServerApplication {
	@Autowired
	private UserEventRepository userEventRepository;

	@Autowired
	private EventRepository eventRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@PostConstruct
	public void populateDB() {
		eventRepository.deleteAll();
		userEventRepository.deleteAll();

		EventModel event1 = new EventModel();
		EventModel event2 = new EventModel();
		EventModel event3 = new EventModel();

		event1.setTitle("Mariages");
		event2.setTitle("Anniversaires");
		event3.setTitle("Enterrements");

		event1.setDescription("Le mariage de vos rêves, à portée de main.");
		event2.setDescription("Un pas de plus vers la mort.");
		event3.setDescription("Ce n'est pas une fatalité; juste un nouveau départ vers l'immortalité.");

		event1.setImageUrl("https://www.ouest-france.fr/sites/default/files/styles/image-900x500/public/2014/12/11/un-mariage-guichet-ferme-pour-patrice-laffont.jpg?itok=C5Rc31PM");
		event2.setImageUrl("https://www.ouest-france.fr/sites/default/files/styles/image-900x500/public/2013/09/30/anniversaire-heureux-pour-les-joutes-nautiques.jpg?itok=UiaYJoFm");
		event3.setImageUrl("https://www.ouest-france.fr/sites/default/files/styles/image-900x500/public/2017/12/09/en-images-les-musiciens-de-johnny-hallyday-en-premiere-ligne-pour-le-patron_0.jpg?itok=cBtxzCHs");

		eventRepository.save(event1);
		eventRepository.save(event2);
		eventRepository.save(event3);
	}
}
