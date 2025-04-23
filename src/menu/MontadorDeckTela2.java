/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import arenas.ArenaCombate;
import jogadores.Jogador;

//Classe MontadorDeckTela2
public class MontadorDeckTela2 extends javax.swing.JFrame {
 private MontadorDeck montadorDeck;
 private MontadorDeck deck1; 
 private MontadorDeck deck2;
 private ArrayList<Jogador> jogadores;

 public MontadorDeckTela2(ArrayList<Jogador> jogadores) {
     this.montadorDeck = new MontadorDeck();
     this.deck1 = new MontadorDeck();
     this.deck2 = new MontadorDeck();
     this.jogadores = new ArrayList<>();
     montadorDeck.setDeck();
     montadorDeck.setDeck2();
     deck1.setDeck();
     deck1.setDeck2();
     deck2.setDeck();
     deck2.setDeck2();
     montadorDeck.receberJogadores(jogadores.get(0));
     montadorDeck.receberJogadores(jogadores.get(1));
     initComponents();
 }

 @SuppressWarnings("unchecked")
 private void initComponents() {

     painel2 = new javax.swing.JPanel();
     btnDeck1 = new javax.swing.JButton();
     lblMensagem = new javax.swing.JLabel();
     btnDeck2 = new javax.swing.JButton();
     jScrollPane2 = new javax.swing.JScrollPane();
     jList1 = new javax.swing.JList<>();
     jScrollPane4 = new javax.swing.JScrollPane();
     jList2 = new javax.swing.JList<>();
     btnAvancar = new javax.swing.JButton(); // Novo botão

     setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

     btnDeck1.setText("Deck 1");
     btnDeck1.addActionListener(evt -> btnDeck1ActionPerformed(evt));

     lblMensagem.setFont(new java.awt.Font("Segoe UI", 0, 24));
     lblMensagem.setForeground(new java.awt.Color(255, 51, 51));
     lblMensagem.setText("Bem vindo ao montador de Deck " + montadorDeck.getArray().get(1).getNome());

     btnDeck2.setText("Deck 2");
     btnDeck2.addActionListener(evt -> btnDeck2ActionPerformed(evt));

     jList1.setModel(new javax.swing.AbstractListModel<String>() {
         String[] strings = montadorDeck.converterArray(deck1.getDeck());
         public int getSize() { return strings.length; }
         public String getElementAt(int i) { return strings[i]; }
     });
     jScrollPane2.setViewportView(jList1);

     jList2.setModel(new javax.swing.AbstractListModel<String>() {
         String[] strings = montadorDeck.converterArray(deck2.getDeck2());
         public int getSize() { return strings.length; }
         public String getElementAt(int i) { return strings[i]; }
     });
     jScrollPane4.setViewportView(jList2);

     // Configuração do botão "Avançar"
     btnAvancar.setText("Avançar");
     btnAvancar.addActionListener(evt -> btnAvancarActionPerformed(evt)); // Adiciona a ação ao clicar

     javax.swing.GroupLayout painel2Layout = new javax.swing.GroupLayout(painel2);
     painel2.setLayout(painel2Layout);
     painel2Layout.setHorizontalGroup(
         painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(painel2Layout.createSequentialGroup()
             .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(painel2Layout.createSequentialGroup()
                     .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(lblMensagem)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel2Layout.createSequentialGroup()
                     .addGap(0, 165, Short.MAX_VALUE)
                     .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(btnDeck1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)))
             .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                 .addComponent(btnDeck2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addContainerGap(139, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel2Layout.createSequentialGroup()
             .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
             .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE) // Tamanho e posição
             .addGap(30, 30, 30)) // Espaço até a borda
     );
     painel2Layout.setVerticalGroup(
         painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(painel2Layout.createSequentialGroup()
             .addContainerGap()
             .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
             .addGap(18, 18, Short.MAX_VALUE)
             .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
             .addGroup(painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(btnDeck1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addComponent(btnDeck2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
             .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE) // Altura do botão
             .addContainerGap(20, Short.MAX_VALUE))
     );

     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
     getContentPane().setLayout(layout);
     layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(painel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
     );
     layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(painel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
     );

     pack();
     setLocationRelativeTo(null);
 }

 private void btnDeck1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     for(int n = 0; n < deck1.getDeck().size(); n++) {
    		montadorDeck.getArray().get(1).receberCarta(montadorDeck.getDeck().get(n));
		}
 }   

 private void btnDeck2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     for(int n = 0; n < deck2.getDeck2().size(); n++) {
    		montadorDeck.getArray().get(1).receberCarta(montadorDeck.getDeck2().get(n));
		}
 }                                        

 private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {                                           
     ArenaCombateTela arenaCombateTela = new ArenaCombateTela(montadorDeck.getArray());
     arenaCombateTela.setVisible(true);
     dispose();
 }      
 public void transferirJogadores(ArenaCombate arena) {
		arena.receberJogadores(jogadores.get(0));
		arena.receberJogadores(jogadores.get(1));
 }

 private javax.swing.JButton btnDeck1;
 private javax.swing.JButton btnDeck2;
 private javax.swing.JButton btnAvancar; // Declaração do novo botão
 private javax.swing.JList<String> jList1;
 private javax.swing.JList<String> jList2;
 private javax.swing.JScrollPane jScrollPane2;
 private javax.swing.JScrollPane jScrollPane4;
 private javax.swing.JLabel lblMensagem;
 private javax.swing.JPanel painel2;
}

