import java.awt.event.*;//For display
import java.awt.*;//for display
import java.lang.Math;//For calculation
import javax.swing.*;//For display



class calc1 extends WindowAdapter implements ActionListener,KeyListener//main class calc1 with window adapter for closing on pressing x button and listeners for reading mouse and key movement
{
JFrame f;//Window
JLabel l,l1;
JPanel p,p1;
float x1=0;
int k,t,qq;
float s;
double a;
JButton c1;//Variables needed while calculation
JButton b[]=new JButton[20];
String s2,x,s1;
public void keyPressed(KeyEvent e)//taking key input
{
int a=e.getKeyCode();
if (a<58 && a>47){
s2=String.valueOf(a-48);
s1=l.getText();
if (t==0){
t=1;
l.setText(s2);
}
else{
l.setText(s1+s2);}
}
if (a<106 && a>95){
s2=String.valueOf(a-96);
s1=l.getText();
if (t==0){
t=1;
l.setText(s2);
}
else{
l.setText(s1+s2);}
}
if (a==8)
l.setText(l.getText().substring(0,l.getText().length()-1));
if (a>105 && a<112){
x=l.getText();
x1=Float.parseFloat(x.toString());
l1.setText(l.getText());
l.setText("0");
t=0;
if (a==106)
k=13;
if (a==107)
k=11;
if (a==109)
k=12;
if (a==111)
k=14;
}
if (a==61){
s1=l.getText();
s=Float.parseFloat(s1);
calcc();
}
}
void calcc(){
if (k==11){
l.setText(""+(s+x1));
}
if (k==12){
l.setText(""+(x1-s));
}
if (k==13){
l.setText(""+(s*x1));
}
if (k==14){
l.setText(""+(x1/s));
}
l1.setText(x+b[k].getText()+s1);
}



public void keyTyped(KeyEvent e)//overwriting abstract class
{}


public void keyReleased(KeyEvent e)//overwriting abstract class
{}



public void actionPerformed(ActionEvent e)//overwriting abstract class
{
JButton bt=(JButton) e.getSource();
s2=bt.getText();
for (int i=0;i<11;i++){
if (b[i]==bt){
s1=l.getText();
if (t==0){
t=1;
l.setText(s2);
}
else{
l.setText(s1+s2);}
}
}
for (int i=11;i<15;i++){
if (b[i]==bt){
x=l.getText();
x1=Float.parseFloat(x.toString());
l.setText("0");
t=0;
k=i;
}}
if (b[16]==bt){
x=l.getText();
x1=Float.parseFloat(x.toString());
k=16;
calc();
t=0;
}
if (b[17]==bt){
x=l.getText();
x1=Float.parseFloat(x.toString());
a=Math.sqrt(x1);
l.setText(""+a);
l1.setText("Sqrt "+x);
t=0;
}
if (b[18]==bt){
x=l.getText();
x1=Float.parseFloat(x.toString());
a=Math.sin(x1);
l.setText(""+a);
l1.setText("Sin "+x);
t=0;
}
if (b[19]==bt){
x=l.getText();
x1=Float.parseFloat(x.toString());
a=Math.cos(x1);
l.setText(""+a);
l1.setText("Cos "+x);
t=0;
}
if (bt==c1){
l.setText("");
x1=0;
k=0;
}
if (b[15]==bt){
s1=l.getText();
s=Float.parseFloat(s1);
calc();
}}


public void windowClosing(WindowEvent e)//For closing window
{
f.dispose();
}


void calc(){
if (k==11){
l.setText(""+(s+x1));
}
if (k==12){
l.setText(""+(x1-s));
}
if (k==13){
l.setText(""+(s*x1));
}
if (k==14){
l.setText(""+(x1/s));
}
if (k==16){
l.setText("Power "+(Math.pow(x1,s)));
}
l1.setText(x+b[k].getText()+s1);
}



calc1()//constructor
{
f=new JFrame();
l=new JLabel("0");
l1=new JLabel("");
l.setFont(new Font("Arial",1,24));
l1.setFont(new Font("Arial",1,22));
f.addWindowListener(this);
p=new JPanel();
p1=new JPanel();
p1.setLayout(new GridLayout(2,1));
p.setLayout(new GridLayout(5,4));
int i;
b[10]=new JButton(".");
b[11]=new JButton("+");
b[12]=new JButton("-");
b[13]=new JButton("*");
b[14]=new JButton("/");
b[15]=new JButton("=");
for(i=11;i<15;i++)
{
b[i].setFont(new Font("Arial",1,24));
b[i].addActionListener(this);
b[i].addKeyListener(this);
p.add(b[i]);
}
for(i=1;i<10;i++)
{
b[i]=new JButton(""+i);
b[i].setFont(new Font("Arial",1,24));
b[i].addActionListener(this);
b[i].addKeyListener(this);
p.add(b[i]);
}
b[0]=new JButton("0");
b[0].setFont(new Font("Arial",1,24));
b[0].addActionListener(this);
b[0].addKeyListener(this);
p.add(b[0]);
b[10].addActionListener(this);
b[10].addKeyListener(this);
b[10].setFont(new Font("Arial",1,24));
p.add(b[10]);
b[15].addActionListener(this);
b[15].addKeyListener(this);
b[15].setFont(new Font("Arial",1,24));
p.add(b[15]);
c1=new JButton("CLEAR");
c1.setFont(new Font("Arial",1,24));
c1.addActionListener(this);
c1.addKeyListener(this);
p1.add(l1);
p1.add(l);
b[16]=new JButton("Pow");
b[17]=new JButton("Sqrt");
b[18]=new JButton("Sin");
b[19]=new JButton("Cos");
b[16].setFont(new Font("Arial",1,22));
b[16].addActionListener(this);
b[16].addKeyListener(this);
b[17].setFont(new Font("Arial",1,22));
b[17].addActionListener(this);
b[17].addKeyListener(this);
b[18].setFont(new Font("Arial",1,22));
b[18].addActionListener(this);
b[18].addKeyListener(this);
b[19].setFont(new Font("Arial",1,22));
b[19].addActionListener(this);
b[19].addKeyListener(this);
p.add(b[16]);
p.add(b[17]);
p.add(b[18]);
p.add(b[19]);
f.add(p1,BorderLayout.NORTH);
f.add(c1,BorderLayout.SOUTH);
f.add(p);
f.setSize(350,450);
f.setVisible(true);
}


public static void main(String ar[])//main function
{
new calc1();
}
}