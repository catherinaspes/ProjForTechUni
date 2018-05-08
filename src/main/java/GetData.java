
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GetData extends JFrame implements ActionListener{

    JFileChooser fileChooser;
    JButton browse, browse2, browse3, upload, upload2, upload3;
    JTextField textField, textField2, textField3;
    FileInputStream in;
    int i;
    File file;

    GetData() {
        super("AppForIvan");
        textField = new JTextField();
        textField.setBounds(20, 50, 190, 30);
        add(textField);

        browse = new JButton("Browse");
        browse.setBounds(250, 50, 80, 30);
        add(browse);
        browse.addActionListener(this);

        upload = new JButton("Upload");
        upload.setBounds(250, 100, 80, 30);
        add(upload);
        upload.addActionListener(this);

        fileChooser = new JFileChooser();
        setLayout(null);
        setSize(400, 300);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == browse) {
                int x = fileChooser.showOpenDialog(null);
                if (x == JFileChooser.APPROVE_OPTION) {
                    copy();
                }
            }
            if (e.getSource() == upload) {
                send();
            }
        } catch (Exception ex) {
        }
    }

    public void copy() throws IOException {
        file = fileChooser.getSelectedFile();

        //db load
        textField.setText(file.getAbsolutePath());
        in = new FileInputStream(file.getAbsolutePath());



    }

    public void send() throws IOException {
        SampleList sampleList = new ZerolineSampleList();

        String filePath = getFile().getAbsolutePath();


        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("Blad wczytywania pliku");
            e.printStackTrace();
        }
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                String divider[] = line.split(";");
                Double firstParam = Double.parseDouble(divider[0]);
                Double secondParam = Double.parseDouble(divider[1]);
                Double thirdParam = Double.parseDouble(divider[2]);
                Double fourthParam = Double.parseDouble(divider[3]);
                Sample sample = new Sample(firstParam,secondParam,thirdParam,fourthParam);
                sampleList.addSample(sample);
            }
        } catch (IOException e) {
            System.out.println("Blad z wczytywaniem linii");
            e.printStackTrace();
        }

        CreatePlot create = new CreatePlot("Wykres 1");
     //   create.drawPlot(sampleList);

    }

    public File getFile() {
        return file;
    }
}

