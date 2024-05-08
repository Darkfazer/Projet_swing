package firstApp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JPanel {

    private List<ProjectCard> projectCards;

    public Window() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20)); // FlowLayout for positioning cards

        // Initialize list of project cards
        projectCards = new ArrayList<>();

        // Add some sample projects (you should load real data from your application)
        addProjectCard(new Project("Project 1", "Client A", "John Doe", "2024-04-01", "2024-07-01", 30));
        addProjectCard(new Project("Project 2", "Client B", "Jane Smith", "2024-05-15", "2024-09-15", 50));
        addProjectCard(new Project("Project 3", "Client C", "Alice Johnson", "2024-06-01", "2024-12-01", 20));
    }

    // Method to add a new project card to the dashboard
    private void addProjectCard(Project project) {
        ProjectCard card = new ProjectCard(project);
        projectCards.add(card);
        add(card);
    }

    // Sample project class (you should create your own project class)
    private class Project {
        private String name;
        private String client;
        private String projectManager;
        private String startDate;
        private String endDate;
        private int progress; // Progress in percentage

        public Project(String name, String client, String projectManager, String startDate, String endDate, int progress) {
            this.name = name;
            this.client = client;
            this.projectManager = projectManager;
            this.startDate = startDate;
            this.endDate = endDate;
            this.progress = progress;
        }

        // Getters for project attributes
        public String getName() {
            return name;
        }

        public String getClient() {
            return client;
        }

        public String getProjectManager() {
            return projectManager;
        }

        public String getStartDate() {
            return startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public int getProgress() {
            return progress;
        }
    }

    // Sample project card class
    private class ProjectCard extends JPanel {
        private Project project;

        public ProjectCard(Project project) {
            this.project = project;
            setPreferredSize(new Dimension(200, 150));
            setBackground(Color.lightGray);
            setBorder(BorderFactory.createLineBorder(Color.darkGray));

            // Create and add components
            JLabel nameLabel = new JLabel("Name: " + project.getName());
            JLabel clientLabel = new JLabel("Client: " + project.getClient());
            JLabel managerLabel = new JLabel("Manager: " + project.getProjectManager());
            JLabel startDateLabel = new JLabel("Start Date: " + project.getStartDate());
            JLabel endDateLabel = new JLabel("End Date: " + project.getEndDate());
            JProgressBar progressBar = new JProgressBar(0, 100);
            progressBar.setValue(project.getProgress());
            progressBar.setStringPainted(true);

            setLayout(new GridLayout(6, 1));
            add(nameLabel);
            add(clientLabel);
            add(managerLabel);
            add(startDateLabel);
            add(endDateLabel);
            add(progressBar);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Project Overview Dashboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new Window());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
