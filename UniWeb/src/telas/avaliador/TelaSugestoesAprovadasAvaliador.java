package telas.avaliador;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import banco.de.dados.DAO.ComentarioDAO;
import banco.de.dados.DAO.LoginDAO;
import banco.de.dados.DAO.SugestaoJTableDAO;
import banco.de.dados.Model.Comentario;
import banco.de.dados.Model.Login;
import banco.de.dados.Model.SugestoesJTable;

import java.awt.*;
import java.awt.event.*;

public class TelaSugestoesAprovadasAvaliador extends JFrame implements ActionListener, MouseListener{

	   //imagen menu
   ImageIcon mp = new ImageIcon(getClass().getResource("img/bntmp.png"));
		
   JButton bntmeuperfil = new JButton(mp);	

   ImageIcon historico = new ImageIcon(getClass().getResource("img/bntns.png"));
		
   JButton bnthistorico = new JButton(historico);	



   ImageIcon novasuges = new ImageIcon(getClass().getResource("img/bnthist.png"));
		
   JButton bntnovasugestao = new JButton(novasuges);	



   ImageIcon sair = new ImageIcon(getClass().getResource("img/bntsair.png"));
		
   JButton bntsair = new JButton(sair);	

   ImageIcon retorn = new ImageIcon(getClass().getResource("img/bntr.png"));
		
   JButton bntretornar = new JButton(retorn);	

	
	

//comentarios
//private JPanel jPanelComentario;
   private JPanel jPanelComentarios;
	
   private JLabel lblescreva, lblcomentarios;
	
   private JTextArea txacomentario;


   private JLabel lblsugestaot,lbltitulo,lblautor,lbldata,espaco,espacoo,espacooo;
	
   private JLabel lbltitulousuario,lbldatausuario,lblautorusuario;
	
   private JTextArea txasugestao;
	
   private JScrollPane scroll;
		
	//private JButton bntmeuperfil, bnthistorico, bntnovasugestao,bntsair,bntretornar; //menu

   private JPanel jPanelMenu,jPanelSugestao,jPanelComentario;
   
   //scroll
   private  JPanel painelFundo;
   private JScrollPane barraRolagem;
   
	//JTable
   private DefaultTableModel modelo = new DefaultTableModel();
   private JPanel JpainelFundo;
   private JTable tabela;
   private JScrollPane JbarraRolagem;


	
	
   public TelaSugestoesAprovadasAvaliador(){
      super("Uni - Sugest�o Aprovada");
   	
      SugestoesJTable sugestao = SugestoesJTable.getInstance();
      
      //comentario
      lblescreva = new JLabel ("                                       Escreva o seu coment�rio ");
      lblcomentarios = new JLabel ("                                Coment�rios");
   	
      jPanelComentario = new JPanel();
      jPanelComentarios = new JPanel();
   	
      txacomentario = new JTextArea(6, 8);
   
         
      
   	
   	//Menu
      espaco  = new JLabel("");
            
             //fundo dos botoes
   
      bntmeuperfil.setContentAreaFilled(false);//tira o fundo
      bnthistorico.setContentAreaFilled(false);
      bntmeuperfil.setBorder(null);//tira as bordas
      bnthistorico.setBorder(null);
      
      bntnovasugestao.setContentAreaFilled(false);
      bntnovasugestao.setBorder(null);//tira as bordas  
      
      bntsair.setContentAreaFilled(false);
      bntsair.setBorder(null);//tira as bordas
      
      bntretornar.setContentAreaFilled(false);
      bntretornar.setBorder(null);//tira as bordas
   
   
   
      //maozinha
   
   
      bntmeuperfil.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bnthistorico.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntnovasugestao.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntsair.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
      bntretornar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
   
   	
   	//
   	
      scroll = new JScrollPane();
   	
   	
      jPanelMenu = new JPanel();
      jPanelSugestao = new JPanel();
      jPanelComentario = new JPanel();
   
   					
     
      //labels
      
      lblsugestaot = new JLabel("             Sugest�o Aprovada!");   
                    
      lbltitulo = new JLabel(" T�tulo: ");
        
      lbldata = new JLabel("Data de postagem:");
        		
      lblautor = new JLabel("Autor: ");
        
      lbltitulousuario = new JLabel(sugestao.getTitulo());
   
      lbldatausuario = new JLabel(sugestao.getData());
        
      lblautorusuario = new JLabel(sugestao.getAutor());
   
      espacoo  = new JLabel("");
      espacooo  = new JLabel("");
   
      //txt    
      txasugestao = new JTextArea(6, 8);
      txasugestao.add(new JScrollPane(new JTextArea(6, 8)));
      txasugestao.setBorder(BorderFactory.createEtchedBorder());
      scroll.setViewportView(txasugestao);
      txasugestao.setText(sugestao.getTexto());
   
   
      Container caixa = getContentPane();
   	
      caixa.setLayout(new BorderLayout());
      caixa.add(jPanelMenu, BorderLayout.WEST);
      caixa.add(jPanelSugestao, BorderLayout.CENTER);
      caixa.add(jPanelComentario, BorderLayout.NORTH);
      caixa.add(jPanelComentarios, BorderLayout.CENTER);
   
   	
   	
   
   	//Painel do Menu
      jPanelMenu.setBackground(new Color(0,102,204));
      jPanelMenu.setPreferredSize(new Dimension(170,200));//tamanha do painel
      jPanelMenu.setLayout(new FlowLayout());
        
      jPanelMenu.add(bntmeuperfil);
      
        
      jPanelMenu.add(bnthistorico);
                
      jPanelMenu.add(bntnovasugestao);
        
      jPanelMenu.add(espaco,BorderLayout.CENTER);
      espaco.setPreferredSize(new Dimension(170,50));;
       
      jPanelMenu.add(bntretornar);
        
      jPanelMenu.add(bntsair);               
        
        
        
           //painel Sugestao
           
      jPanelSugestao.setBackground(new Color(255,255,255));  
      jPanelSugestao.setLayout(new FlowLayout());
      jPanelSugestao.setPreferredSize(new Dimension(600,980));
   
        
   
      jPanelSugestao.add(lblsugestaot); 
      lblsugestaot.setFont(new Font("Arial", 1, 34)); 
      lblsugestaot.setForeground(new Color(0, 102, 204));
      lblsugestaot.setPreferredSize(new Dimension(600,100));
            
      jPanelSugestao.add(lbltitulo);
      lbltitulo.setFont(new Font("Arial", 0, 18)); 
      lbltitulo.setForeground(new Color(0, 0, 0));
           
           //lbl com o titulo da sugest�o
           
      jPanelSugestao.add(lbltitulousuario); 
      lbltitulousuario.setFont(new Font("Arial", 0, 18)); 
      lbltitulousuario.setForeground(new Color(0, 102, 204));
      lbltitulousuario.setPreferredSize(new Dimension(550,30));
   	   
      jPanelSugestao.add(txasugestao);
      txasugestao.setPreferredSize(new Dimension(610,250));
      txasugestao.setEditable(false);
   
      jPanelSugestao.add(lblautor);
      lblautor.setFont(new Font("Arial", 0, 18)); 
      lblautor.setForeground(new Color(0, 0, 0));
           
           //lbl com o nome do Autor
      jPanelSugestao.add(lblautorusuario);
      lblautorusuario.setFont(new Font("Arial", 0, 18)); 
      lblautorusuario.setForeground(new Color(0, 102, 204));
      lblautorusuario.setPreferredSize(new Dimension(545,20));
           
      jPanelSugestao.add(lbldata); 
      lbldata.setFont(new Font("Arial", 0, 18)); 
      lbldata.setForeground(new Color(0, 0, 0));
           
           
            //lbl a data da postagem
           
      jPanelSugestao.add(lbldatausuario); 
      lbldatausuario.setFont(new Font("Arial", 0, 18)); 
      lbldatausuario.setForeground(new Color(0, 102, 204));
      lbldatausuario.setPreferredSize(new Dimension(450,20));
           
      jPanelSugestao.add(espacoo); 
      espacoo.setPreferredSize(new Dimension(600,20));
                     
      jPanelSugestao.add(jPanelComentario, BorderLayout.SOUTH);
           
       
         // scroll
      painelFundo = new JPanel();
      painelFundo.setLayout(new GridLayout(1,1));
      barraRolagem = new JScrollPane(jPanelSugestao);
      painelFundo.add(barraRolagem); 
      setSize(40,100);
      setVisible(true);
      getContentPane().add(painelFundo);
        
       
      
       //fim  scroll
   
        //Painel Comentario
      jPanelComentario.setBackground(new Color(255,255,255));
      jPanelComentario.setPreferredSize(new Dimension(650,1000));
      jPanelComentario.setLayout(new FlowLayout());
      jPanelComentario.setBorder(BorderFactory.createEtchedBorder());
   	
   	
      jPanelComentario.add(lblcomentarios);
      lblcomentarios.setPreferredSize(new Dimension(600,30));
      lblcomentarios.setFont(new Font("Arial", 1, 24)); 
      lblcomentarios.setForeground(new Color(0, 102, 204));
   	
        //Jtable
      JpainelFundo = new JPanel();
      jPanelComentario.add(JpainelFundo);
      JpainelFundo.setPreferredSize(new Dimension(590,400));
      JpainelFundo.setLayout(new GridLayout(1, 1));
   
        
      tabela = new JTable(modelo);
      JbarraRolagem = new JScrollPane(tabela);
      JpainelFundo.add(BorderLayout.CENTER, JbarraRolagem);
      modelo.addColumn("Coment�rio");
      modelo.addColumn("Autor");
      modelo.addColumn("Data");
      modelo.addColumn("Hor�rio");
      tabela.getColumnModel().getColumn(0).setPreferredWidth(250);
      tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
      tabela.getColumnModel().getColumn(2).setPreferredWidth(20);
      tabela.getColumnModel().getColumn(3).setPreferredWidth(20);
      PreencherComentario(modelo);
   	
        //fim JTable
   
   	//botoes		
      bntmeuperfil.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bnthistorico.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bntnovasugestao.setPreferredSize(new Dimension(140,100));//tamanho do bota0
      bntsair.setPreferredSize(new Dimension(140,60));//tamanho do bota0
      bntretornar.setPreferredSize(new Dimension(140,80));//tamanho do bota0
   	
      bntmeuperfil.addActionListener(this);
      bnthistorico.addActionListener(this);
      bntnovasugestao.addActionListener(this);
      bntretornar.addActionListener(this);
      bntsair.addActionListener(this);
   
		// Adiciona a a��o na JTable
		tabela.addMouseListener(this);
       
        
        
        //Padroes da tela
      setSize(840,620);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null); // deixa a posi��o da janela no meio
      setResizable(false);//N�o deixa maximizar
      setVisible(true);
   }
	
   public void actionPerformed(ActionEvent e) {
   	
      Login lo = Login.getInstance();
   	
      if (e.getSource() == bntmeuperfil) {
         this.dispose();
         new telas.avaliador.TelaMeuPerfil().setVisible(true);  
      }
   	
      if (e.getSource() == bnthistorico) {
      	
      	
         if(lo.getCategoria().equals("Apoio")){
            this.dispose();
            new telas.avaliador.TelaSugestoesPostadasApoio().setVisible(true);  
         }
         else{
            if(lo.getCategoria().equals("Cursos")){
               this.dispose();
               new telas.avaliador.TelaSugestoesPostadasCursos().setVisible(true); 
            	
            }
            else{
               if(lo.getCategoria().equals("Eventos")){
                  this.dispose();
                  new telas.avaliador.TelaSugestoesPostadasEventos().setVisible(true); 
               	
               }
               else{
                  if(lo.getCategoria().equals("Infraestrutura")){
                     this.dispose();
                     new telas.avaliador.TelaSugestoesPostadasInfraestrutura().setVisible(true); 
                  	
                  }
                  else{
                     if(lo.getCategoria().equals("Seguran�a")){
                        this.dispose();
                        new telas.avaliador.TelaSugestoesPostadasSeguranca().setVisible(true); 
                     }
                     else{
                        if(lo.getCategoria().equals("Sugest�es Livres")){
                           this.dispose();
                           new telas.avaliador.TelaSugestoesPostadasSugestoesLivres().setVisible(true); 
                        }
                        else{
                           JOptionPane.showMessageDialog(null, "Voc� ainda n�o foi registrado em nenhuma categoria, aguarde at� um Superior verificar o seu caso!"); 
                        }
                     }
                  }
               }
            }
         }
      }
   	
      if (e.getSource() == bntnovasugestao) {
      		
          if(lo.getCategoria().equals("Apoio")){
              this.dispose();
              new telas.avaliador.TelaRelatorio().setVisible(true);  
           }
          else{
             if(lo.getCategoria().equals("Cursos")){
                 this.dispose();
                 new telas.avaliador.TelaRelatorio().setVisible(true);  
              }
             else{
                if(lo.getCategoria().equals("Eventos")){
                    this.dispose();
                    new telas.avaliador.TelaRelatorio().setVisible(true);  
                 }
                else{
                   if(lo.getCategoria().equals("Infraestrutura")){
                       this.dispose();
                       new telas.avaliador.TelaRelatorio().setVisible(true);  
                    }
                   else{
                      if(lo.getCategoria().equals("Seguran�a")){
                          this.dispose();
                          new telas.avaliador.TelaRelatorio().setVisible(true);  
                       }
                      else{
                         if(lo.getCategoria().equals("Sugest�es Livres")){
                            this.dispose();
                            new telas.avaliador.TelaRelatorio().setVisible(true);  
                         }
                         else{
                            JOptionPane.showMessageDialog(null, "Voc� ainda n�o foi registrado em nenhuma categoria, aguarde at� um Superior verificar o seu caso!"); 
                         }
                      }
                   }
                }
             }
          }
       }
   	
      if (e.getSource() == bntretornar) {
      
         this.dispose();
         new telas.avaliador.TelaPrincipal().setVisible(true);  
      }
   	
      if (e.getSource() == bntsair) {
         this.dispose();
         new telas.TelaLogin().setVisible(true);  
      }
   			
   }
   public static void PreencherComentario(DefaultTableModel modelo) {
   	
      modelo.setNumRows(0);
   	
      ComentarioDAO comentar = new ComentarioDAO();
   	
   
      for(Comentario c: comentar.CarregarComentarios()){
         modelo.addRow(new Object[]{
            	
            	c.getComentario(),
            	c.getAutor(),
            	c.getData(),
            	c.getHora()});
      }
   }
	public void mouseClicked(MouseEvent e) {
		if(tabela.getSelectedRow() != -1){
			
			
			JOptionPane.showMessageDialog(null, "Coment�rio: " + tabela.getValueAt(tabela.getSelectedRow(), 0).toString() 
										+ "\nAutor: " + tabela.getValueAt(tabela.getSelectedRow(), 1).toString()
										+ "\nData: " + tabela.getValueAt(tabela.getSelectedRow(), 2).toString()
										+ "\nHor�rio: " + tabela.getValueAt(tabela.getSelectedRow(), 3).toString());

		} 

}
public void mousePressed(MouseEvent e) {


}
public void mouseReleased(MouseEvent e) {


}
public void mouseEntered(MouseEvent e) {


}
public void mouseExited(MouseEvent e) {


}
}
