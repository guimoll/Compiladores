/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CompiladorPanel;

import Gals.LexicalError;
import Gals.Lexico;
import Gals.SemanticError;
import Gals.Semantico;
import Gals.Sintatico;
import Gals.SyntaticError;
import Gals.Token;
import InformacaoLinha.IdLinha;
import InformacaoLinha.InformacaoLinha;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CompiladorPainel extends javax.swing.JFrame {

    private boolean arquivoNovo = true;
    
    private File arquivoExistente = null;
    
    private String conteudoArquivoIL = "";
    
    public CompiladorPainel() {
        initComponents();
        barraStatus.setText("");
        caixaEditor.setBorder(new IdentificadorLinha());
        caixaMensagem.setEditable(false);
        atalhoBotoes();
        painelPrincipal.setMinimumSize(new java.awt.Dimension(900, 620));
    }
    
    public void atalhoBotoes() {

        btnNovo.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK), "btnNovo");
        btnNovo.getActionMap().put("btnNovo", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                caixaEditor.setText("");
                caixaMensagem.setText("");
                
                arquivoNovo = true;
            }
        });
        
        btnAbrir.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK), "btnAbrir");
        btnAbrir.getActionMap().put("btnAbrir", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirArquivo();
            }
        });
        
        btnSalvar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK), "btnSalvar");
        btnSalvar.getActionMap().put("btnSalvar", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarArquivo();
            }
        });
        
        btnCopiar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK), "btnCopiar");
        btnCopiar.getActionMap().put("btnCopiar", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                ClipboardOwner conteudoCopiar = new StringSelection(caixaEditor.getSelectedText());
                clipboard.setContents((Transferable) conteudoCopiar, conteudoCopiar);
            }
        });
        
        btnColar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK), "btnColar");
        btnColar.getActionMap().put("btnColar", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                caixaEditor.paste();
            }
        });
        
        btnRecortar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK), "btnRecortar");
        btnRecortar.getActionMap().put("btnRecortar", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                caixaEditor.cut();
            }
        });
        
        btnCompilar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "btnCompilar");
        btnCompilar.getActionMap().put("btnCompilar", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
               caixaMensagem.setText("Compilação de programas ainda não foi implementada.");
            }
        });
        
        btnEquipe.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "btnEquipe");
        btnEquipe.getActionMap().put("btnEquipe", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                barraStatus.setText("Equipe: Patrick Antunes e Guilherme Moll Silva");
            }
        });
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        barraIcones = new javax.swing.JPanel();
        btnAbrir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCopiar = new javax.swing.JButton();
        btnColar = new javax.swing.JButton();
        btnRecortar = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnEquipe = new javax.swing.JButton();
        barraStatus = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        caixaEditor = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        caixaMensagem = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setSize(new java.awt.Dimension(900, 600));

        painelPrincipal.setMaximumSize(new java.awt.Dimension(1200, 900));
        painelPrincipal.setMinimumSize(new java.awt.Dimension(900, 620));
        painelPrincipal.setPreferredSize(new java.awt.Dimension(900, 620));

        barraIcones.setAlignmentX(0.0F);
        barraIcones.setAlignmentY(0.0F);
        barraIcones.setAutoscrolls(true);
        barraIcones.setMaximumSize(new java.awt.Dimension(1000000, 1000000));
        barraIcones.setMinimumSize(new java.awt.Dimension(150, 570));
        barraIcones.setPreferredSize(new java.awt.Dimension(150, 900));
        barraIcones.setRequestFocusEnabled(false);

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CompiladorImgs/Abrir.png"))); // NOI18N
        btnAbrir.setText("abrir[ctrl-o]");
        btnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbrir.setMaximumSize(new java.awt.Dimension(100, 200));
        btnAbrir.setPreferredSize(new java.awt.Dimension(112, 112));
        btnAbrir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CompiladorImgs/Salvar.png"))); // NOI18N
        btnSalvar.setText("salvar[ctrl-s]");
        btnSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCopiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CompiladorImgs/Copiar.png"))); // NOI18N
        btnCopiar.setText("copiar[ctrl-c]");
        btnCopiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCopiar.setPreferredSize(new java.awt.Dimension(93, 60));
        btnCopiar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCopiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarActionPerformed(evt);
            }
        });

        btnColar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CompiladorImgs/Colar.png"))); // NOI18N
        btnColar.setText("colar[ctrl-v]");
        btnColar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnColar.setPreferredSize(new java.awt.Dimension(89, 60));
        btnColar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnColar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnColar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColarActionPerformed(evt);
            }
        });

        btnRecortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CompiladorImgs/Cortar.png"))); // NOI18N
        btnRecortar.setText("recortar[ctrl-x]");
        btnRecortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRecortar.setVerifyInputWhenFocusTarget(false);
        btnRecortar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnRecortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRecortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecortarActionPerformed(evt);
            }
        });

        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CompiladorImgs/Compilar.png"))); // NOI18N
        btnCompilar.setText("compilar[F7]");
        btnCompilar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCompilar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCompilar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CompiladorImgs/Novo.png"))); // NOI18N
        btnNovo.setText("novo[ctrl-n]");
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setMaximumSize(new java.awt.Dimension(100, 200));
        btnNovo.setMinimumSize(new java.awt.Dimension(100, 521));
        btnNovo.setPreferredSize(new java.awt.Dimension(112, 112));
        btnNovo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        btnNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNovoKeyPressed(evt);
            }
        });

        btnEquipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CompiladorImgs/Equipe.png"))); // NOI18N
        btnEquipe.setText("equipe[F1]");
        btnEquipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEquipe.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEquipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barraIconesLayout = new javax.swing.GroupLayout(barraIcones);
        barraIcones.setLayout(barraIconesLayout);
        barraIconesLayout.setHorizontalGroup(
            barraIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraIconesLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(barraIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addComponent(btnColar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRecortar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCompilar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnCopiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEquipe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        barraIconesLayout.setVerticalGroup(
            barraIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraIconesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnColar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnRecortar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEquipe)
                .addGap(388, 388, 388))
        );

        barraStatus.setText("Pasta/Arquivo");

        jSplitPane1.setDividerLocation(450);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        caixaEditor.setColumns(20);
        caixaEditor.setLineWrap(true);
        caixaEditor.setRows(5);
        caixaEditor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(caixaEditor);

        jSplitPane1.setTopComponent(jScrollPane1);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setToolTipText("");
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        caixaMensagem.setEditable(false);
        caixaMensagem.setColumns(20);
        caixaMensagem.setRows(5);
        caixaMensagem.setMinimumSize(new java.awt.Dimension(900, 25));
        jScrollPane2.setViewportView(caixaMensagem);

        jSplitPane1.setRightComponent(jScrollPane2);

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(barraIcones, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSplitPane1)
                        .addContainerGap())
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addComponent(barraStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                        .addGap(168, 168, 168))))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraIcones, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSplitPane1)
                        .addGap(6, 6, 6)))
                .addComponent(barraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipeActionPerformed
        caixaMensagem.setText("Equipe: Patrick Antunes e Guilherme Moll Silva");
    }//GEN-LAST:event_btnEquipeActionPerformed

    private void btnNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNovoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovoKeyPressed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        caixaEditor.setText("");
        caixaMensagem.setText("");
        barraStatus.setText("");
        arquivoNovo = true;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        Lexico lexico = new Lexico();
        Sintatico sintatico = new Sintatico();
        Semantico semantico = new Semantico();
        lexico.setInput(new StringReader(caixaEditor.getText()));
        IdLinha identificadorLinha = new IdLinha();
        caixaMensagem.setText("");
        this.conteudoArquivoIL = "";
        try {
            if (!"".equals(caixaEditor.getText().trim())) {
                Token token;
                //String format = "%1$-5s %2$-20s %3$-5s";
                //caixaMensagem.append(String.format(format, "LINHA","CLASSE","LEXEMA")+"\n");
                while ((token = lexico.nextToken()) != null) {
                    try{
                        /*InformacaoLinha linha = identificadorLinha.getLinha(caixaEditor.getText(), token.getPosition());
                        String classe = identificarClasse(token.getId());
                        if (classe != null){
                            caixaMensagem.append(String.format(format, linha.getLinha(), classe, token.getLexeme())+"\n");
                        }*/
                    }catch(Exception ex){
                        System.out.println(ex);
                    }
                }
                
                lexico.setInput(new StringReader(caixaEditor.getText()));
                sintatico.parse(lexico, semantico);
                
                List<String> x = semantico.getCodigo();
                for (int i = 0; i < x.size(); i++){
                    this.conteudoArquivoIL = this.conteudoArquivoIL + x.get(i).toString();
                }
                
                caixaMensagem.append("Programa compilado com sucesso: \n \n " + this.conteudoArquivoIL);
            } else {
                caixaMensagem.setText("");
                caixaMensagem.append("Não há o que compilar.");
            }
        } catch (LexicalError e) {
            try {
                InformacaoLinha linha = identificadorLinha.getLinha(caixaEditor.getText(), e.getPosition());
                caixaMensagem.setText("");
                String msgErro = e.getMessage();
                
                if ("Símbolo inválido".equals(msgErro)) {
                    msgErro = identificadorLinha.getSimboloInvalido(e.getPosition(), caixaEditor.getText()) + " " + msgErro;
                }
                caixaMensagem.append("Erro na linha " + linha.getLinha() + " - " + msgErro);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } catch (SyntaticError e) {
            try {
                InformacaoLinha linha = identificadorLinha.getLinha(caixaEditor.getText(), e.getPosition());
                caixaMensagem.setText("");
                String msgErro = " - encontrado  " + sintatico.getCurrentToken().getLexeme() + "\n" + e.getMessage();
                
                caixaMensagem.append("Erro na linha " + linha.getLinha() + msgErro);
            } catch (Exception ex) {
               System.out.println(ex);
            }
        } catch (SemanticError e) {
        }
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void tratarErroLexico(IdLinha identificadorLinha, LexicalError e){
        try {
            InformacaoLinha linha = identificadorLinha.getLinha(caixaEditor.getText(), e.getPosition());
            caixaMensagem.setText("");
            String msgErro = e.getMessage();
            if ("Símbolo inválido".equals(msgErro)) {
                msgErro = identificadorLinha.getSimboloInvalido(e.getPosition(), caixaEditor.getText()) + " " + msgErro;
            }
                caixaMensagem.append("Erro na linha " + linha.getLinha() + " - " + msgErro);
            } catch (Exception ex) {
                System.out.println(ex);
            }
    }
    
    private String getLinha(char c){
        System.out.println(c);
        String str = caixaEditor.getText();
        int index = str.indexOf(c);
        int lineNumber = 1;

        for (int i = 0; i < index; i++) {
            if (str.charAt(i) == '\n') {
                lineNumber++;
            }
}       return String.valueOf(lineNumber);
    }
    
    private String getClasseToken(Token t){
        
        if(t.getId() == 2){
            return "Identificador";
        } else if(t.getId() == 3){
            return "Constante inteira";
        } else if(t.getId() == 4){
            return "Constante float";
        } else if(t.getId() == 5){
            return "Constante binária";
        } else if(t.getId() == 6){
            return "Constante String";
        } else if(t.getId() >= 7 && t.getId() <= 22){
            return "Simbolo especial";
        } else if(t.getId() >= 23 && t.getId() <= 34){
            return "Palavra reservada";
        }
        
        return "Erro";
    }
    
    private void btnRecortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecortarActionPerformed
        caixaEditor.cut();
    }//GEN-LAST:event_btnRecortarActionPerformed

    private void btnColarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColarActionPerformed
        caixaEditor.paste();
    }//GEN-LAST:event_btnColarActionPerformed

    private void btnCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarActionPerformed
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        ClipboardOwner conteudoCopiar = new StringSelection(caixaEditor.getSelectedText());
        clipboard.setContents((Transferable) conteudoCopiar, conteudoCopiar);
    }//GEN-LAST:event_btnCopiarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarArquivo();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        abrirArquivo();
    }//GEN-LAST:event_btnAbrirActionPerformed

    public void abrirArquivo(){
        JFileChooser arquivo = new JFileChooser();
        
        FileNameExtensionFilter filtroTXT = new FileNameExtensionFilter("Arquivos TXT", "txt");  
        arquivo.addChoosableFileFilter(filtroTXT);
        arquivo.setAcceptAllFileFilterUsed(false);
       
        if(arquivo.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            
        caixaEditor.setText("");
        barraStatus.setText("");
        
        String diretorioArquivo = arquivo.getSelectedFile().getAbsolutePath().toUpperCase();
        barraStatus.setText("Aberto o arquivo: " + arquivo.getSelectedFile().getName().toUpperCase() + " no diretório: " + diretorioArquivo);
       
        File arquivoLeitura = arquivo.getSelectedFile();
        
        String conteudo = "";
        try{
            conteudo = Files.readAllLines(arquivoLeitura.toPath()).stream().collect(Collectors.joining("\n"));
            arquivoNovo = false; //Se importar o conteúdo não é mais um arquivo novo.
            arquivoExistente = arquivoLeitura;
            
            }catch(Exception e){
        };
        
        caixaEditor.setText(conteudo);
    }
    }
    
    public void salvarArquivo(){
        String conteudoSalvar = caixaEditor.getText(); //independente do caso salvo o conteúdo do editor de texto

        if (arquivoNovo == true){
            JFileChooser arquivoNovo = new JFileChooser();   
                if(arquivoNovo.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                String arquivoNome = arquivoNovo.getSelectedFile() + ".il";
                    try{
                        editarArquivo(arquivoNome, conteudoSalvar);
                        caixaMensagem.setText("");
                        barraStatus.setText("Arquivo salvo em: " + arquivoNome);
                    }catch(Exception e){
                };
            }
        }else{
              try{
                    editarArquivo(arquivoExistente.getAbsolutePath(), conteudoSalvar);
                    caixaMensagem.setText("");
                    arquivoExistente = new File(arquivoExistente.getAbsolutePath());
              }catch(Exception e){
            };      
        }
    }
    
    private void editarArquivo(String nomeArquivo, String conteudoTexto) throws IOException {
        try (
            //BufferedReader leitura = new BufferedReader(new StringReader(conteudoTexto));
            BufferedReader leitura = new BufferedReader(new StringReader(this.conteudoArquivoIL));
            PrintWriter escrita = new PrintWriter(new FileWriter(nomeArquivo)); ) {
            leitura.lines().forEach(line -> escrita.println(line));
        }
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompiladorPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompiladorPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompiladorPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompiladorPainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new CompiladorPainel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraIcones;
    private javax.swing.JLabel barraStatus;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnColar;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnCopiar;
    private javax.swing.JButton btnEquipe;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRecortar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextArea caixaEditor;
    private javax.swing.JTextArea caixaMensagem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables
}

