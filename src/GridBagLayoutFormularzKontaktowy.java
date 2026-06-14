import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridBagLayoutFormularzKontaktowy extends JFrame {

    // Deklaracja komponentów
    private JTextField txtImie;
    private JTextField txtNazwisko;
    private JTextField txtEmail;
    private JTextField txtTelefon;
    private JTextField txtTemat;
    private JButton btnWyslij;
    private JButton btnWyczysc;
    private JLabel lblStatus;

    public GridBagLayoutFormularzKontaktowy() {
        // Ustawienia okna
        setTitle("Formularz kontaktowy (GridBagLayout)");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel z GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Obiekt ograniczeń – będziemy go modyfikować dla każdego komponentu
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // marginesy wokół każdego komponentu
        gbc.fill = GridBagConstraints.HORIZONTAL; // rozciąganie poziome

        // --- Wiersz 0: Imię (kolumna 0-1) i Nazwisko (kolumna 2-3) ---

        // Etykieta "Imię" – kolumna 0, wiersz 0
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // zajmuje 1 kolumnę
        gbc.weightx = 0.0; // etykieta nie rozciąga się
        panel.add(new JLabel("Imię:"), gbc);

        // Pole "Imię" – kolumna 1, wiersz 0
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5; // rozciąga się, waga 0.5
        txtImie = new JTextField(10);
        panel.add(txtImie, gbc);

        // Etykieta "Nazwisko" – kolumna 2, wiersz 0
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        panel.add(new JLabel("Nazwisko:"), gbc);

        // Pole "Nazwisko" – kolumna 3, wiersz 0
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        txtNazwisko = new JTextField(10);
        panel.add(txtNazwisko, gbc);

        // --- Wiersz 1: Email – rozciągnięty na 3 kolumny ---

        // Etykieta "Email" – kolumna 0, wiersz 1
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        panel.add(new JLabel("Email:"), gbc);

        // Pole "Email" – kolumna 1, wiersz 1, rozciągnięte na 3 kolumny
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3; // zajmuje 3 kolumny!
        gbc.weightx = 1.0;
        txtEmail = new JTextField();
        panel.add(txtEmail, gbc);

        // --- Wiersz 2: Telefon – rozciągnięty na 3 kolumny ---

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        panel.add(new JLabel("Telefon:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        txtTelefon = new JTextField();
        panel.add(txtTelefon, gbc);

        // --- Wiersz 3: Temat – rozciągnięty na 3 kolumny ---

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        panel.add(new JLabel("Temat:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        txtTemat = new JTextField();
        panel.add(txtTemat, gbc);

        // --- Wiersz 4: Przyciski ---

        // Przycisk "Wyślij" – kolumna 1, wiersz 4
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        gbc.fill = GridBagConstraints.NONE; // przycisk NIE rozciąga się
        gbc.anchor = GridBagConstraints.EAST; // wyrównanie do prawej
        btnWyslij = new JButton("Wyślij");
        panel.add(btnWyslij, gbc);

        // Przycisk "Wyczyść" – kolumna 2, wiersz 4
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST; // wyrównanie do lewej
        btnWyczysc = new JButton("Wyczyść");
        panel.add(btnWyczysc, gbc);

        // --- Wiersz 5: Status – rozciągnięty na 4 kolumny ---

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        lblStatus = new JLabel("Wypełnij formularz i kliknij Wyślij", SwingConstants.CENTER);
        lblStatus.setForeground(Color.GRAY);
        panel.add(lblStatus, gbc);

        // Dodajemy panel do okna
        add(panel);

        // === Obsługa zdarzeń ===

        btnWyslij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sprawdzamy, czy wymagane pola są wypełnione
                if (txtImie.getText().trim().isEmpty()
                        || txtNazwisko.getText().trim().isEmpty()
                        || txtEmail.getText().trim().isEmpty()) {
                    lblStatus.setForeground(Color.RED);
                    lblStatus.setText("Błąd: Imię, Nazwisko i Email są wymagane!");
                } else {
                    lblStatus.setForeground(new Color(0, 128, 0));
                    lblStatus.setText("Wiadomość wysłana od: "
                            + txtImie.getText() + " " + txtNazwisko.getText());
                }
            }
        });

        btnWyczysc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtImie.setText("");
                txtNazwisko.setText("");
                txtEmail.setText("");
                txtTelefon.setText("");
                txtTemat.setText("");
                lblStatus.setForeground(Color.GRAY);
                lblStatus.setText("Formularz wyczyszczony");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new GridBagLayoutFormularzKontaktowy();
    }
}