import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Clinica {
    private List<Patient> patients;
    private List<Consultation> consultations;
    private List<Exam> exams;

    public Clinica() {
        patients = new ArrayList<>();
        consultations = new ArrayList<>();
        exams = new ArrayList<>();
    }

    public void addPatient(String name, String cpf) {
        Patient patient = new Patient(name, cpf);
        patients.add(patient);
        JOptionPane.showMessageDialog(null, "Paciente Adicionado: " + patient);
    }

    public void scheduleConsultation(String cpf, LocalDateTime dateAndTime) {
        Patient patient = findPatientByCpf(cpf);
        if (patient!= null) {
            Consultation consultation = new Consultation(patient, dateAndTime);
            consultations.add(consultation);
            JOptionPane.showMessageDialog(null, "Consultar: " + consultation);
        } else {
            JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
        }
    }

    public void addExam(String cpf, String description, String result) {
        Patient patient = findPatientByCpf(cpf);
        if (patient!= null) {
            Exam exam = new Exam(patient, description, result);
            exams.add(exam);
            JOptionPane.showMessageDialog(null, "Exame Adicionado: " + exam);
        } else {
            JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
        }
    }

    public void viewExams(String cpf) {
        Patient patient = findPatientByCpf(cpf);
        if (patient!= null) {
            String examsString = "Exames do Paciente: " + patient.getName() + "\n";
            for (Exam exam : exams) {
                if (exam.getPatient().equals(patient)) {
                    examsString += exam + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, examsString);
        } else {
            JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
        }
    }

    private Patient findPatientByCpf(String cpf) {
        for (Patient patient : patients) {
            if (patient.getCpf().equals(cpf)) {
                return patient;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Clinica clinic = new Clinica();

        OUTER:
        while (true) {
            String option = JOptionPane.showInputDialog("1. Adicionar Paciente\n2. Consultar Exames\n3. Adicionar Exame\n4. Ver Exames\n5. Exit");
            int optionInt = Integer.parseInt(option);
            switch (optionInt) {
                case 1 -> {
                    String name = JOptionPane.showInputDialog("Informe o nome do Paciente:");
                    String cpf = JOptionPane.showInputDialog("Informe o CPF do Paciente:");
                    clinic.addPatient(name, cpf);
                }
                case 2 -> {
                    String cpf = JOptionPane.showInputDialog("Informe o CPF do Paciente :");
                    String dateAndTimeString = JOptionPane.showInputDialog("insira data e hora (dd/MM/yyyy--hh:00):");
                    LocalDateTime dateAndTime = LocalDateTime.parse(dateAndTimeString);
                    clinic.scheduleConsultation(cpf, dateAndTime);
                }
                case 3 -> {
                    String cpf = JOptionPane.showInputDialog("insira o CPF do paciente:");
                    String description = JOptionPane.showInputDialog("Insira a descrição do exame:");
                    String result = JOptionPane.showInputDialog("Insira o Resultado do Exame:");
                    clinic.addExam(cpf, description, result);
                }
                case 4 -> {
                    String cpf = JOptionPane.showInputDialog("Insira o CPF do Paciente:");
                    clinic.viewExams(cpf);
                }
                case 5 -> {
                    break OUTER;
                }
                default -> JOptionPane.showMessageDialog(null, "Opção invalida. Tente Novamente.");
            }
        }
    }
}

class Patient {
    private String name;
    private String cpf;

    public Patient(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }
}

class Consultation {
    private Patient patient;
    private LocalDateTime dateAndTime;

    public Consultation(Patient patient, LocalDateTime dateAndTime) {
        this.patient = patient;
        this.dateAndTime = dateAndTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }
}

class Exam {
    private Patient patient;
    private String description;
    private String result;

    public Exam(Patient patient, String description, String result) {
        this.patient = patient;
        this.description = description;
        this.result = result;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDescription() {
        return description;
    }

    public String getResult() {
        return result;
    }
}