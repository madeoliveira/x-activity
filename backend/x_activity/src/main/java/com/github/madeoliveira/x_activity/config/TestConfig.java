package com.github.madeoliveira.x_activity.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.madeoliveira.x_activity.entities.Anthropometry;
import com.github.madeoliveira.x_activity.entities.Bioimpedance;
import com.github.madeoliveira.x_activity.entities.Exercise;
import com.github.madeoliveira.x_activity.entities.Group;
import com.github.madeoliveira.x_activity.entities.Planner;
import com.github.madeoliveira.x_activity.entities.PlannerExercise;
import com.github.madeoliveira.x_activity.entities.Register;
import com.github.madeoliveira.x_activity.entities.User;
import com.github.madeoliveira.x_activity.entities.enums.PlannerStatus;
import com.github.madeoliveira.x_activity.repositories.AnthropometryRepository;
import com.github.madeoliveira.x_activity.repositories.BioimpedanceRepository;
import com.github.madeoliveira.x_activity.repositories.ExerciseRepository;
import com.github.madeoliveira.x_activity.repositories.GroupRepository;
import com.github.madeoliveira.x_activity.repositories.PlannerExerciseRepository;
import com.github.madeoliveira.x_activity.repositories.PlannerRepository;
import com.github.madeoliveira.x_activity.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PlannerRepository plannerRepository;
	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private ExerciseRepository exerciseRepository;

	@Autowired
	private PlannerExerciseRepository plannerExerciseRepository;

	@Autowired
	private BioimpedanceRepository bioimpedanceRepository;

	@Autowired
	private AnthropometryRepository anthropometryRepository;

	@Override
	public void run(String... args) throws Exception {

		Group group1 = new Group(null, "Peito");
		Group group2 = new Group(null, "Ombro");
		Group group3 = new Group(null, "Perna");
		Group group4 = new Group(null, "Biceps");

		Exercise exercise1 = new Exercise(null, "Barra fixa supinada",
				"Em uma barra suspensa, se pendure com a palma da m??o virada para voc?? (pegada supinada), puxe o corpo para cima levando o queixo acima da barra e aproximando os cotovelos ao tronco");
		Exercise exercise2 = new Exercise(null, "Agachamento",
				" Para realizar o exerc??cio, posicione-se em p??, com o corpo ereto e as pernas levemente abertas, mantendo os p??s na mesma linha dos ombros e com os dedos dos p??s apontando suavemente para fora.");
		Exercise exercise3 = new Exercise(null, "Eleva????o frontal",
				"Colocar os bra??os ao lado do corpo e subir para frente at?? a linha do ombro.");
		Exercise exercise4 = new Exercise(null, "Encolhimento de ombros",
				"Colocar o bra??o ao lado do corpo e fazer o movimento subindo os ombros, sem dobrar os cotovelos, mantendo eles sempre retos.");
		Exercise exercise5 = new Exercise(null, "Supino inclinado com halteres",
				"Posicionamento do corpo no banco e utilizar uma inclina????o de banco entre 30?? a 45??, a posi????o que d?? maior foco no peitoral superior. Se for muito inclinado, acabar?? estimulando o anterior de ombro demais.");

		groupRepository.saveAll(Arrays.asList(group1, group2, group3, group4));
		exerciseRepository.saveAll(Arrays.asList(exercise1, exercise2, exercise3));

		exercise1.getGroups().add(group4);
		exercise2.getGroups().add(group3);
		exercise3.getGroups().add(group2);
		exercise4.getGroups().add(group2);
		exercise5.getGroups().add(group1);

		exerciseRepository.saveAll(Arrays.asList(exercise1, exercise2, exercise3, exercise4, exercise5));

		User user1 = new User(null, "Rafael", "rafael@gmail.com", "111888585", "sdfwef");
		User user2 = new User(null, "Marcos", "marcos@gmail.com", "1234112121", "FDGFDGD");
		User user3 = new User(null, "Marcio", "marcio@gmail.com", "65345435", "fgtfhhyg");
		User user4 = new User(null, "Jo??o", "marcos@gmail.com", "4112121", "FDGFDGD");

		Register reg1 = new Register(null, "3890123-45", "343435567", "Rua David, 88", "Barra Funda", "S??o Paulo", "M",
				user1);
		Register reg2 = new Register(null, "3726247-25", "987654345", "Rua jARAGUA, 231", "Barra Funda", "S??o Paulo",
				"M", user2);
		Register reg3 = new Register(null, "2345567-95", "398578578", "Av. Ipiranga, 919", "Barra Funda", "S??o Paulo",
				"M", user3);
		Register reg4 = new Register(null, "3726247-25", "857654345", "AV. Rio Branco, 956", "Barra Funda", "S??o Paulo",
				"M", user4);

		user1.setRegister(reg1);
		user2.setRegister(reg2);
		user3.setRegister(reg3);
		user4.setRegister(reg4);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);

		Planner planner1 = new Planner(null, Instant.parse("2022-03-13T11:45:08Z"), PlannerStatus.Concluir,
				"Manter a respira????o", user1);
		Planner planner2 = new Planner(null, Instant.parse("2022-03-14T12:15:03Z"), PlannerStatus.Historico,
				"N??o perder o foco", user2);
		Planner planner3 = new Planner(null, Instant.parse("2022-03-15T18:28:10Z"), PlannerStatus.Disponivel,
				"Abdomem sempre contraido", user3);
		Planner planner4 = new Planner(null, Instant.parse("2022-03-13T11:45:08Z"), PlannerStatus.Concluir,
				"Consentra????o nos movimentos", user4);
		Planner planner5 = new Planner(null, Instant.parse("2022-03-15T18:28:10Z"), PlannerStatus.Disponivel,
				"Abdomem sempre contraido", user1);
		Planner planner6 = new Planner(null, Instant.parse("2022-03-13T11:45:08Z"), PlannerStatus.Concluir,
				"Consentra????o nos movimentos", user1);

		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
		plannerRepository.saveAll(Arrays.asList(planner1, planner2, planner3, planner4, planner5, planner6));

		PlannerExercise plannerExercise1 = new PlannerExercise(planner1, exercise4, 3, 12, 18.0,"A");
		PlannerExercise plannerExercise2 = new PlannerExercise(planner1, exercise3, 3, 10, 10.0,"B");
		PlannerExercise plannerExercise3 = new PlannerExercise(planner2, exercise1, 4, 15, 12.0,"B");
		PlannerExercise plannerExercise4 = new PlannerExercise(planner3, exercise4, 2, 16, 11.0,"A");
		PlannerExercise plannerExercise5 = new PlannerExercise(planner1, exercise5, 5, 8, 14.0,"B");

		plannerExerciseRepository.saveAll(Arrays.asList(plannerExercise1, plannerExercise2, plannerExercise3,
				plannerExercise4, plannerExercise5));

		Bioimpedance bio1 = new Bioimpedance(null, Instant.parse("2020-03-13T11:40:08Z"), 26.9, 69.9, 35.4, 2.4, 17.6, 48.0, 3.0, 28, user1);
		Bioimpedance bio2 = new Bioimpedance(null, Instant.parse("2020-05-13T11:45:08Z"), 25.9, 70.0, 35.9, 2.5, 17.5, 48.0, 3.0, 29, user1);
		Bioimpedance bio3 = new Bioimpedance(null, Instant.parse("2020-08-13T11:45:08Z"), 24.9, 70.9, 36.2, 3.2, 17.2, 48.0, 3.0, 28, user1);

		Bioimpedance bio4 = new Bioimpedance(null, Instant.parse("2020-02-13T11:45:08Z"), 26.9, 69.9, 35.4, 2.4, 17.6, 48.0, 3.0, 32, user2);
		Bioimpedance bio5 = new Bioimpedance(null, Instant.parse("2020-04-13T11:45:08Z"), 25.1, 70.8, 36.2, 3.2, 17.2, 48.0, 3.0, 30, user2);
		Bioimpedance bio6 = new Bioimpedance(null, Instant.parse("2020-09-13T11:45:08Z"), 25.9, 70.0, 35.9, 2.5, 17.5, 48.0, 3.0, 31, user2);

		Bioimpedance bio7 = new Bioimpedance(null, Instant.parse("2020-03-13T11:45:08Z"), 26.9, 69.9, 35.4, 2.4, 17.6, 48.0, 3.0, 28, user3);
		Bioimpedance bio8 = new Bioimpedance(null, Instant.parse("2020-06-13T11:45:08Z"), 25.9, 70.0, 35.9, 2.5, 17.5, 48.0, 3.0, 29, user3);
		Bioimpedance bio9 = new Bioimpedance(null, Instant.parse("2020-09-13T11:45:08Z"), 24.9, 70.9, 36.2, 3.2, 17.2, 48.0, 3.0, 28, user3);

		Bioimpedance bio10 = new Bioimpedance(null, Instant.parse("2020-02-13T11:45:08Z"), 26.9, 69.9, 35.4, 2.4, 17.6, 48.0, 3.0, 32, user4);
		Bioimpedance bio11 = new Bioimpedance(null, Instant.parse("2020-04-13T11:45:08Z"), 25.1, 70.8, 36.2, 3.2, 17.2, 48.0, 3.0, 30, user4);
		Bioimpedance bio12 = new Bioimpedance(null, Instant.parse("2020-07-13T11:45:08Z"), 25.9, 70.0, 35.9, 2.5, 17.5, 48.0, 3.0, 31, user4);

		bioimpedanceRepository
				.saveAll(Arrays.asList(bio1, bio2, bio3, bio4, bio5, bio6, bio7, bio8, bio9, bio10, bio11, bio12));

		Anthropometry anthr1 = new Anthropometry(null, Instant.parse("2020-03-13T11:40:08Z"), 19.0, 11.00, 12.0, 10.0, 13.0, 26.0, 8.0, 10.0, 22.0, 33.8, 72.3,
				98.1, 78.1, 29.0, 57.2, 36.9, 16.0, user1);
		Anthropometry anthr2 = new Anthropometry(null, Instant.parse("2020-05-13T11:45:08Z"), 18.5, 11.50, 13.0, 10.8, 13.2, 26.4, 8.5, 11.0, 21.0, 33.7, 72.5,
				98.1, 78.1, 29.0, 57.2, 36.9, 16.0, user1);
		Anthropometry anthr3 = new Anthropometry(null, Instant.parse("2020-08-13T11:45:08Z"), 18.0, 12.00, 13.5, 10.4, 13.9, 26.6, 8.8, 12.0, 20.0, 33.6, 72.9,
				98.1, 78.1, 29.0, 57.2, 36.9, 16.0, user1);

		Anthropometry anthr4 = new Anthropometry(null, Instant.parse("2020-02-13T11:45:08Z"), 19.0, 11.00, 12.0, 10.0, 13.0, 26.0, 8.0, 10.0, 22.0, 33.8, 72.3,
				98.1, 78.1, 29.0, 57.2, 36.9, 16.0, user2);
		Anthropometry anthr5 = new Anthropometry(null, Instant.parse("2020-04-13T11:45:08Z"),18.0, 12.00, 13.5, 10.4, 13.9, 26.6, 8.8, 12.0, 20.0, 33.6, 72.9,
				98.1, 78.1, 29.0, 57.2, 36.9, 16.0, user2);
		Anthropometry anthr6 = new Anthropometry(null, Instant.parse("2020-09-13T11:45:08Z"), 19.0, 11.00, 12.0, 10.0, 13.0, 26.0, 8.0, 10.0, 22.0, 33.8, 72.3,
				98.1, 78.1, 29.0, 57.2, 36.9, 16.0, user2);

		Anthropometry anthr7 = new Anthropometry(null, Instant.parse("2020-03-13T11:45:08Z"), 18.5, 11.50, 13.0, 10.8, 13.2, 26.4, 8.5, 11.0, 21.0, 33.7, 72.5,
				98.1, 78.1, 29.0, 57.2, 36.9, 16.0, user3);
		Anthropometry anthr8 = new Anthropometry(null, Instant.parse("2020-06-13T11:45:08Z"), 19.0, 11.00, 12.0, 10.0, 13.0, 26.0, 8.0, 10.0, 22.0, 33.8, 72.3,
				98.1, 78.1, 29.0, 57.2, 36.9, 16.0, user3);
		Anthropometry anthr9 = new Anthropometry(null, Instant.parse("2020-09-13T11:45:08Z"), 19.0, 11.00, 12.0, 10.0, 13.0, 26.0, 8.0, 10.0, 22.0, 33.8, 72.3,
				98.1, 78.1, 29.0, 57.2, 36.9, 16.0, user3);

		Anthropometry anthr10 = new Anthropometry(null, Instant.parse("2020-02-13T11:45:08Z"), 18.5, 11.50, 13.0, 10.8, 13.2, 26.4, 8.5, 11.0, 21.0, 33.7,
				72.3, 98.1, 78.1, 29.0, 57.2, 36.9, 16.0, user4);
		Anthropometry anthr11 = new Anthropometry(null, Instant.parse("2020-04-13T11:45:08Z"), 19.0, 11.00, 12.0, 10.0, 13.0, 26.0, 8.0, 10.0, 22.0, 33.8,
				72.3, 98.1, 78.1, 29.0, 57.2, 36.9, 16.0, user4);
		Anthropometry anthr12 = new Anthropometry(null, Instant.parse("2020-07-13T11:45:08Z"), 18.0, 12.00, 13.5, 10.4, 13.9, 26.6, 8.8, 12.0, 20.0, 33.6, 
				72.3, 98.1, 78.1, 29.0, 57.2, 36.9, 16.0, user4);

		anthropometryRepository.saveAll(Arrays.asList(anthr1, anthr2, anthr3, anthr4, anthr5, anthr6, anthr7, anthr8,
				anthr9, anthr10, anthr11, anthr12));

	}

}
