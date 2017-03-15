import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Notepad extends JPanel{
	Notepad(){
	JFrame f1 = new JFrame();
	 //Create a JPanel
		 JPanel panel=new JPanel();

	 	f1.setSize(1280,720);
		f1.setVisible(true) ;
		f1.setResizable(true);
		f1.setTitle("Notepad");
		Toolkit t = Toolkit.getDefaultToolkit();
		f1.setIconImage(t.getImage("D://note.png"));
    	f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    	panel.setLayout(new BorderLayout());
    	//JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	JTextArea display = new JTextArea ( 16, 58 );
    JScrollPane scroll = new JScrollPane ( display );
   //scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

    //Add Textarea in to middle panel
    panel.add ( scroll );



    	//JTextArea textArea = new JTextArea("", 0,0);
    	//TextArea textArea = new TextArea("");
		//textArea.setFont(new Font("Century Gothic", Font.BOLD, 12));
		//f1.add(textArea);




		 //Create a scrollbar using JScrollPane and add panel into it's viewport
		 //Set vertical and horizontal scrollbar always show
		JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);



	 //Add JScrollPane into JFrame

		f1.add(scrollBar);

		//f1.getContentPane().add(textArea); // the BorderLayout bit makes it fill it automatically
		//f1.setContentPane(pane);



int fileToOpen;
int fileToSave;
JFileChooser fileOpen;
JFileChooser fileSave;




		MenuBar mbar;
		Menu Edit,Help,Format,File,View;
		MenuItem m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11;

		mbar=new MenuBar();//menubar
		File=new Menu("File");//create menu
				m1=new MenuItem("New               ctrl+N");
				m2=new MenuItem("Open...          ctrl+O");
				m3=new MenuItem("Save              ctrl+S");
				m4=new MenuItem("Save as...");
				m5=new MenuItem("Page setup...");
				m6=new MenuItem("Print...            ctrl+P");//add menu item
				m7=new MenuItem("Exit");
				File.add(m1);
				File.add(m2);
				File.add(m3);
				File.addSeparator();
				File.add(m4);
				File.add(m5);
				File.add(m6);
				File.addSeparator();
				File.add(m7);//add item to menu
				mbar.add(File);//add menu to menu bar

		Edit=new Menu("Edit");
				m1=new MenuItem("Undo               ctrl+Z");
				m2=new MenuItem("Cut                  ctrl+X");
				m3=new MenuItem("Copy               ctrl+C");
				m4=new MenuItem("Paste              ctrl+V");
				m5=new MenuItem("Delete             Del");
				m6=new MenuItem("Find...             ctrl+F");//add menu item
				m7=new MenuItem("Find Next        F3");
				m8=new MenuItem("Replace...       ctrl+H");
				m9=new MenuItem("Go To...           ctrl+G");
				m10=new MenuItem("Select All      ctrl+A");
				m11=new MenuItem("Time/Date     F5");
								Edit.add(m1);
								Edit.addSeparator();
								Edit.add(m2);
								Edit.add(m3);
								Edit.add(m4);
								Edit.add(m5);
								Edit.addSeparator();
								Edit.add(m6);

								Edit.add(m7);
								Edit.add(m8);
								Edit.add(m9);
								Edit.addSeparator();
								Edit.add(m10);
								Edit.add(m11);
								mbar.add(Edit);


		Format=new Menu("Format");
				m1=new MenuItem("Word Wrap");
				m2=new MenuItem("Font...");
				Format.add(m1);
				Format.add(m2);
				mbar.add(Format);

		View=new Menu("View");
			m1=new MenuItem("Status Bar");
			View.add(m1);
			mbar.add(View);


		Help=new Menu("Help");
					m1=new MenuItem("View Help");
					m2=new MenuItem("About Notepad");
					Help.add(m1);
					Help.addSeparator();
					Help.add(m2);
					mbar.add(Help);
					f1.setMenuBar(mbar);// attach to frame


					m1.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								textArea.setText("");
							}
						});

						m2.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								openFile();
								if (fileToOpen == JFileChooser.APPROVE_OPTION){
									textArea.setText("");
									try{
										Scanner scan = new Scanner(new FileReader(fileOpen.getSelectedFile().getPath()));
										while (scan.hasNext())
											textArea.append(scan.nextLine());
									} catch (Exception ex){
										System.out.println(ex.getMessage());
									}
								}
							}
						});

						m3.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								saveFile();
								if (fileToSave == JFileChooser.APPROVE_OPTION){
									try {
										BufferedWriter out = new BufferedWriter(new FileWriter(fileSave.getSelectedFile().getPath()));
										out.write(JTextArea.getText());
										out.close();
									} catch (Exception ex) {
										System.out.println(ex.getMessage());
									}
								}
							}
						});

						m7.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								System.exit(0);
							}
	});


				}

public static void main(String[] args) {
    new Notepad();
       }
}









