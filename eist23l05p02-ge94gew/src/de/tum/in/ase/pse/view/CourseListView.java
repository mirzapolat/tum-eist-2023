package de.tum.in.ase.pse.view;

import de.tum.in.ase.pse.controller.Controller;
import de.tum.in.ase.pse.model.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class CourseListView extends Stage implements Observer {

	private static final int SCENE_WIDTH = 400;
	private static final int SCENE_HEIGHT = 400;
	private final ObservableList<Course> courses;
	private final ListView<Course> courseListView;
	private Controller controller;
	private Button createButton;

	// TODO: Update the constructor. Make sure that all parameters are set correctly
	//  and the view observes all courses
	public CourseListView(Controller controller, List<Course> courseList) {
		this.courses = FXCollections.observableArrayList(courseList);
		this.courseListView = new ListView<>(courses);

		for (Course c : courses) {
			c.addObserver(this);
		}

		generateUserInterface();

		this.controller = controller;
		this.controller.setCourseListView(this);
	}

	public void addCourse(Course course) {
		if (!courses.contains(course)) {
			courses.add(course);
			course.addObserver(this);
		}
	}

	private void selectCourse(Course course) {
		controller.selectCourse(course);
	}

	private void createCourse() {
		controller.selectCourse(new Course());
	}

	@Override
	public void update() {
		displayCourses();
	}

	private void displayCourses() {
		courseListView.refresh();
	}

	private void generateUserInterface() {
		VBox vbox = new VBox();

		createButton = new Button("Create a course");
		createButton.setOnAction(event -> createCourse());

		Label courseListLabel = new Label("Course List");
		courseListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		courseListView.setOnMouseClicked(event -> selectCourse(courseListView.getSelectionModel().getSelectedItem()));
		vbox.getChildren().addAll(courseListLabel, courseListView, createButton);

		Scene scene = new Scene(vbox, SCENE_WIDTH, SCENE_HEIGHT);
		setScene(scene);
		setTitle("Course List");
		displayCourses();
	}
}
