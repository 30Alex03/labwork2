package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;

public class GUI extends javax.swing.JFrame {

    Manager manager = new Manager();

    public GUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        Panel = new javax.swing.JPanel();
        ExportButton = new javax.swing.JButton();
        ImportButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        TextFieldForVariant = new javax.swing.JTextField();
        VariantLabel = new javax.swing.JLabel();
        IsIndexRadioButton = new javax.swing.JRadioButton();
        isTextRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ExportButton.setText("Экспорт");
        ExportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportButtonActionPerformed(evt);
            }
        });

        ImportButton.setText("Импорт");
        ImportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportButtonActionPerformed(evt);
            }
        });

        ExitButton.setText("Выход");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        buttonGroup2.add(IsIndexRadioButton);
        IsIndexRadioButton.setText("Выбрать варинат числом");
        IsIndexRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsIndexRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup2.add(isTextRadioButton);
        isTextRadioButton.setText("Введите вариант текстом");
        isTextRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isTextRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExitButton)
                    .addComponent(ImportButton)
                    .addComponent(ExportButton))
                .addGap(44, 44, 44)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(isTextRadioButton)
                    .addComponent(IsIndexRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextFieldForVariant, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addComponent(VariantLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGap(33, 33, 33))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(VariantLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ImportButton)
                            .addComponent(isTextRadioButton))
                        .addGap(16, 16, 16)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ExportButton)
                            .addComponent(IsIndexRadioButton)))
                    .addComponent(TextFieldForVariant, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(ExitButton)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportButtonActionPerformed
        if (TextFieldForVariant.getText().trim().isBlank()) {
            JOptionPane.showMessageDialog(this, "Укажите вариант");
            return;
        }
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Exel files", "xlsx"));
        int window = fileChooser.showDialog(this, "Выберете файл");
        if (window == JFileChooser.APPROVE_OPTION) {
            try {
                manager.Import(fileChooser.getSelectedFile().getAbsolutePath(),
                        TextFieldForVariant.getText(), IsIndexRadioButton.isSelected());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Вариант указан неверно(укажите число)");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(this, "Вариант указан неверно");
            } catch (NotOfficeXmlFileException e) {
                JOptionPane.showMessageDialog(this, "Указан неверный формат файла");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, "Вариант указан неверно(нет листа по такому индексу)");
            } catch (IllegalStateException e) {
                JOptionPane.showMessageDialog(this, "Выбран не тот файл");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "Системе не удается найти указанный путь");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Произошла ошибка при чтении файла");
            }
        }
    }//GEN-LAST:event_ImportButtonActionPerformed

    private void ExportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportButtonActionPerformed
        if (manager.getStorage().getData().isEmpty()) {
            JOptionPane.showMessageDialog(this, "вы ещё не загрузили данные");
            return;
        }
        JFileChooser fileChooser = new JFileChooser();
        int window = fileChooser.showDialog(this, "Выберете файл");
        if (window == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".xlsx")) {
                filePath += ".xlsx";
            }
            try {
                manager.Export(filePath);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Произошла ошибка при записи файла");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Произошла ошибка при записи файла");
            }
        }
    }//GEN-LAST:event_ExportButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void IsIndexRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsIndexRadioButtonActionPerformed
        if (IsIndexRadioButton.isSelected() == true) {
            VariantLabel.setText("Введите вариант числом");
        }
        else  { VariantLabel.setText("Укажите способ");}
    }//GEN-LAST:event_IsIndexRadioButtonActionPerformed

    private void isTextRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isTextRadioButtonActionPerformed
        if(isTextRadioButton.isSelected() == true) {
            VariantLabel.setText("Введите вариант текстом");
        } else {
        VariantLabel.setText("Укажите способ");
          }
    }//GEN-LAST:event_isTextRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton ExportButton;
    private javax.swing.JButton ImportButton;
    private javax.swing.JRadioButton IsIndexRadioButton;
    private javax.swing.JPanel Panel;
    private javax.swing.JTextField TextFieldForVariant;
    private javax.swing.JLabel VariantLabel;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton isTextRadioButton;
    // End of variables declaration//GEN-END:variables
}
