/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Comparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author Titouan FLOCH
 */
public class GestionRequetes
{
    static ObservableList<ClubEtCoureurs> lesClubsEtCoureurs = FXCollections.observableArrayList();
    static ObservableList<Coureurs> lesCoureurs = FXCollections.observableArrayList();
    static ObservableList<Club> lesClubs = FXCollections.observableArrayList();
    static ObservableList<ClassementCourseCoureurs> lesCoursesCoureurs = FXCollections.observableArrayList();
    static ObservableList<ClassementChallengeCoureurs> leClassementCoureurs = FXCollections.observableArrayList();
    static ObservableList<ClassementCoureur> lesCoursesCoureur = FXCollections.observableArrayList();
    static ObservableList<CoureurIndividuel> lesCoureursClassement = FXCollections.observableArrayList();
        public static ObservableList<Club> listeClubs()
            {
                Statement stmt;
                ResultSet rs;
                String pilote = "org.gjt.mm.mysql.Driver";
                String urle = new String("jdbc:mysql://localhost/projetjava");
                Club club;
                 try
                    {
                        Class.forName(pilote);
                        Connection conn = DriverManager.getConnection(urle,"root","");
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("select * from club");

                        while (rs.next())
                            {
                                club= new Club(rs.getString("nom"),rs.getString("adresse"),rs.getString("cp"),rs.getString("ville"),rs.getString("nomPresident"));
                                lesClubs.add(club);
                            }
                       stmt.close();

                    }
                catch (Exception e)
                    {
                          System.out.println("Erreur Requete de chargement : " + e.getMessage());
                    }
                return lesClubs;
            } 
        public static ObservableList<Course> listeCourse()
            {
                Statement stmt;
                ResultSet rs;
                String pilote = "org.gjt.mm.mysql.Driver";
                String urle = new String("jdbc:mysql://localhost/projetjava");
                Course course;
                ObservableList<Course> lesCourses = FXCollections.observableArrayList();
                try
                {
                        Class.forName(pilote);
                        Connection conn = DriverManager.getConnection(urle,"root","");
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("select * from course");

                        while (rs.next())
                        {
                            course= new Course(rs.getString("nom"),rs.getString("lieu"),rs.getDate("date"),rs.getTime("heureDepart"),rs.getFloat("distance"),rs.getInt("prix"),rs.getBoolean("challenge"));
                            lesCourses.add(course);
                        }
                       stmt.close();

                    }
                 catch (Exception e)
                    {
                        System.out.println("Erreur Requete de chargement : " + e.getMessage());
                    }
                return lesCourses;
            }
        static public Course RequeteCoursePlusProche()
            {
                Course course = null;
                String requete = "select * from course where date = (select min(date) from course where date > now()) group by nom";
                Statement stmt;
                ResultSet rs;
                String pilote = "org.gjt.mm.mysql.Driver";
                String urle = new String("jdbc:mysql://localhost/projetjava");
                    try
                        {
                           Class.forName(pilote);
                           Connection conn = DriverManager.getConnection(urle,"root","");
                           stmt = conn.createStatement();
                           rs = stmt.executeQuery(requete);
                           rs.next();
                           course = new Course(rs.getString("nom"),rs.getString("lieu"),rs.getDate("date"),rs.getTime("heureDepart"),rs.getFloat("distance"),rs.getInt("prix"),rs.getBoolean("challenge"));
                           stmt.close();            
                        }
                    catch (Exception e)
                        {
                              System.out.println("Erreur Requete de chargement : " + e.getMessage());
                        }
                return course;
            }       
        public static void insertCourreur(String clubChoisis,String sexeChoisis,String nomChoisis,String prenomChoisis,String anneeChoisis,String adresseChoisis,String CPChoisis,String villeChoisis,String adresseMailChoisis,String pointsPrecedentChoisis,String pointsActuelleChoisis,String noTelChoisis)
             {
                String insertion = "insert into coureur value('"+clubChoisis+"','"+nomChoisis+"','"+prenomChoisis+"','"+sexeChoisis+"',"+anneeChoisis+",'"+adresseChoisis+"','"+CPChoisis+"','"+villeChoisis+"','"+noTelChoisis+"','"+adresseMailChoisis+"',"+pointsPrecedentChoisis+","+pointsActuelleChoisis+")";
                Statement stmt;
                int rs;
                String pilote = "org.gjt.mm.mysql.Driver";
                String urle = new String("jdbc:mysql://localhost/projetjava");
                try
                    {
                        Class.forName(pilote);
                        Connection conn = DriverManager.getConnection(urle,"root","");
                        stmt = conn.createStatement();
                        rs = stmt.executeUpdate(insertion);
                    }
                catch (Exception e)
                  {
                        System.out.println("Erreur Requete de chargement : " + e.getMessage());
                  }
             }
        static public ObservableList<ClubEtCoureurs> requeteClubEtCoureurs()
            {     
               
               ClubEtCoureurs club;
               Statement stmt;
               ResultSet rs;
               String pilote = "org.gjt.mm.mysql.Driver";
               String urle = new String("jdbc:mysql://localhost/projetjava");
               String requete = "select club.nom,club.adresse,club.cp,club.ville,nompresident,count(coureur.nom) as 'nombre de coureurs' from club,coureur where club.nom = coureur.nomClub group by club.nom UNION select club.nom,club.adresse,club.cp,club.ville,nompresident,0 from club,coureur";
               try
                    {
                       Class.forName(pilote);
                       Connection conn = DriverManager.getConnection(urle,"root","");
                       stmt = conn.createStatement();
                       rs = stmt.executeQuery(requete);
                       while (rs.next())
                        {
                            club = new ClubEtCoureurs(rs.getString("nom"),rs.getString("adresse"),rs.getString("cp"),rs.getString("ville"),rs.getString("nomPresident"),rs.getInt("nombre de coureurs"));
                            lesClubsEtCoureurs.add(club);               
                        }
                        stmt.close();   
                    }
                  catch (Exception e)
                    {
                          System.out.println("Erreur Requete de chargement : " + e.getMessage());
                    }
               return lesClubsEtCoureurs;
            }
        static public ObservableList<Coureurs>ListeCoureurs()
          {
              Coureurs coureur;
               Statement stmt;
               ResultSet rs;
               String pilote = "org.gjt.mm.mysql.Driver";
               String urle = new String("jdbc:mysql://localhost/projetjava");
               String requete = "SELECT * FROM `coureur` ";
               try
                    {
                       Class.forName(pilote);
                       Connection conn = DriverManager.getConnection(urle,"root","");
                       stmt = conn.createStatement();
                       rs = stmt.executeQuery(requete);
                       while (rs.next())
                        {
                            coureur = new Coureurs(rs.getString("nomClub"),rs.getString("nom"),rs.getString("prenom"),rs.getString("adresse"),rs.getString("cp"),rs.getString("ville"),rs.getString("tel"),rs.getString("email"));
                            lesCoureurs.add(coureur);               
                        }
                        stmt.close();   
                    }
                  catch (Exception e)
                    {
                          System.out.println("Erreur Requete de chargement : " + e.getMessage());
                    }
              
              return lesCoureurs;
          }       
        static public void insertionDansBDD(String nouvNom,String nouvLieu,LocalDate nouvDate,String nouvHeureDepart,String nouvDistance,String nouvPrix,int nouvChallenge)
            {
                Statement stmt;
                    ResultSet rs;
                    String pilote = "org.gjt.mm.mysql.Driver";
                    String urle = new String("jdbc:mysql://localhost/projetjava");
                    try
                    {
                        Class.forName(pilote);
                        Connection conn = DriverManager.getConnection(urle,"root","");
                        stmt = conn.createStatement();
                        String requete = "insert into course values('"+nouvNom+"','"+nouvLieu+"','"+nouvDate+"','"+nouvHeureDepart+"','"+nouvDistance+"','"+nouvPrix+"','"+nouvChallenge+"')";
                        stmt.executeUpdate(requete);
                       stmt.close();             
                    }
                  catch (Exception e)
                    {
                          System.out.println("Erreur Requete de chargement : " + e.getMessage());
                    }
                    System.out.println("Ajout effectué");
            }
        static public void insertionNouvClub(String nom,String adresse,String CP,String ville, String nomPresident)
          {
              Statement stmt;
                    ResultSet rs;
                    String pilote = "org.gjt.mm.mysql.Driver";
                    String urle = new String("jdbc:mysql://localhost/projetjava");
                    try
                    {
                        Class.forName(pilote);
                        Connection conn = DriverManager.getConnection(urle,"root","");
                        stmt = conn.createStatement();
                        String requete = "insert into club values('"+nom+"','"+adresse+"','"+CP+"','"+ville+"','"+nomPresident+"')";
                        stmt.executeUpdate(requete);
                        stmt.close();
                        System.out.println("Ajout du club effectué");
                    }
                  catch (Exception e)
                    {
                          System.out.println("Erreur Requete de chargement : " + e.getMessage());
                    }
                   
          }
        static public void modificationClub(String nom,String adresse,String cp,String ville,String nomPresident)
          {
            String requete = "update club set adresse = '" + adresse+"' ,cp = '"+cp+"' ,ville = '" + ville + "', nomPresident = '"+nomPresident+"' where nom ='"+ nom+"'";
            Statement stmt;
            int rs;
            String pilote = "org.gjt.mm.mysql.Driver";
            String urle = new String("jdbc:mysql://localhost/projetjava");
            try
                {
                    Class.forName(pilote);
                    Connection conn = DriverManager.getConnection(urle,"root","");
                    stmt = conn.createStatement();
                    rs = stmt.executeUpdate(requete);
                    stmt.close();
                    System.out.println("modifications effectuées");
                }
            catch (Exception e)
              {
                    System.out.println("Erreur Requete de chargement : " + e.getMessage());
              }
          }
        static public void modificationCoureur(String nouvNomClub,String nouvNom,String nouvPrenom,String nouvAdresse,String nouvCP,String nouvTel,String nouvVille,String nouvEmail,String nom)
          {
            String requete = "update coureur set nomClub ='"+nouvNomClub+"' , nom = '"+nouvNom+"',prenom = '"+nouvPrenom+"',adresse = '"+nouvAdresse+"',cp = '"+nouvCP+"',ville = '"+nouvVille+"',tel = '"+nouvTel+"',email = '"+nouvEmail+"'where nom = '"+nom+"'";
            Statement stmt;
            int rs;
            String pilote = "org.gjt.mm.mysql.Driver";
            String urle = new String("jdbc:mysql://localhost/projetjava");
            try
                {
                    Class.forName(pilote);
                    Connection conn = DriverManager.getConnection(urle,"root","");
                    stmt = conn.createStatement();
                    rs = stmt.executeUpdate(requete);
                    stmt.close();
                    System.out.println("modifications effectuées");
                }
            catch (Exception e)
              {
                    System.out.println("Erreur Requete de chargement : " + e.getMessage());
              }
          }
        static public ObservableList<ClassementCourseCoureurs> RecuperationCoureur(String nomCourse)
          {
            String requete = "SELECT * FROM `courir` WHERE nomCourse = '"+nomCourse+"' order by place asc";
            Statement stmt;
            ResultSet rs; 
            ClassementCourseCoureurs unCoureur;
            String pilote = "org.gjt.mm.mysql.Driver";
            String urle = new String("jdbc:mysql://localhost/projetjava");
            try
                {
                    Class.forName(pilote);
                    Connection conn = DriverManager.getConnection(urle,"root","");
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(requete);
                
                    while(rs.next())
                    {
                        unCoureur = new ClassementCourseCoureurs(rs.getString("nomCoureur"),rs.getString("prenomCoureur"),rs.getInt("place"),rs.getTime("temps"));
                        lesCoursesCoureurs.add(unCoureur);
                    }
                        stmt.close();
                }
            catch (Exception e)
              {
                    System.out.println("Erreur Requete de chargement : " + e.getMessage());
              }
            return lesCoursesCoureurs;
          }
         
        static public ObservableList<ClassementChallengeCoureurs> RecuperationClassementCoureurs()
        {
            String nom;
            String prenom;
            Statement stmt;
            ResultSet rs; 
            int nombrePoints = 0;
            ClassementChallengeCoureurs unCoureur;
            String requete = "select nomCourse, nomCoureur,prenomCoureur,sum(challenge) from courir,course where nomCourse = nom and challenge = 1 group by nomCoureur,prenomCoureur having sum(challenge) >= 5";
            String pilote = "org.gjt.mm.mysql.Driver";
            String urle = new String("jdbc:mysql://localhost/projetjava");
            try
                {
                    Class.forName(pilote);
                    Connection conn = DriverManager.getConnection(urle,"root","");
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(requete);
                    while(rs.next())
                        {
                            nom = rs.getString("nomCoureur");
                            prenom = rs.getString("prenomCoureur");
                            Statement stmt2;
                            ResultSet rs2;  
                            String requete2 = "select nomCourse,nomCoureur,prenomCoureur,place from courir,course where nomCoureur = '"+ nom +"' and prenomCoureur = '"+prenom+"' and nomCourse = course.nom and challenge = 1 group by nomCourse order by place asc limit 5";
                            String pilote2 = "org.gjt.mm.mysql.Driver";
                            String urle2 = new String("jdbc:mysql://localhost/projetjava");
                            try
                                {
                                
                                   Class.forName(pilote);
                                   Connection conn2 = DriverManager.getConnection(urle,"root","");
                                   stmt2 = conn2.createStatement();
                                   rs2 = stmt2.executeQuery(requete2);
                                   while (rs2.next())
                                   {
                                      nombrePoints = nombrePoints + rs2.getInt("place");
                                   }
                                   unCoureur = new ClassementChallengeCoureurs(nom,prenom,nombrePoints);
                                   nombrePoints = 0;
                                   leClassementCoureurs.add(unCoureur);                                
                                }
                            catch (Exception e)
                                {
                                    System.out.println("Erreur Requete de chargement : " + e.getMessage());
                                }
                        }
                }
            catch (Exception e)
                {
                      System.out.println("Erreur Requete de chargement : " + e.getMessage());
                }
            return leClassementCoureurs;
        }
       static public void ecrireCSV()
        {
            String nomCourse;
            Statement stmt1;
            ResultSet rs1; 
            String requete1 = "SELECT distinct nomCourse from courir";
            String pilote1 = "org.gjt.mm.mysql.Driver";
            String urle1 = new String("jdbc:mysql://localhost/projetjava");
            try
            {
                Class.forName(pilote1);
                Connection conn = DriverManager.getConnection(urle1,"root","");
                stmt1 = conn.createStatement();
                rs1 = stmt1.executeQuery(requete1);
                while(rs1.next())
                {
                  Statement stmt2;
                  ResultSet rs2; 
                  String pilote2 = "org.gjt.mm.mysql.Driver";
                  String urle2 = new String("jdbc:mysql://localhost/projetjava");
                  nomCourse = rs1.getString("nomCourse");
                  String nomFichier = "résultat"+nomCourse+".csv";
                  System.out.println(nomFichier);
                  FileWriter fileWriter = new FileWriter(nomFichier);
                  fileWriter.close();
                  String requete2 = "SELECT place,nomCoureur,prenomCoureur,temps FROM courir WHERE nomCourse = '"+nomCourse+"' order by place asc";
                  try
                    {
                        Class.forName(pilote2);
                        Connection conn2 = DriverManager.getConnection(urle2,"root","");
                        stmt2 = conn2.createStatement();
                        rs2 = stmt2.executeQuery(requete2);
                        PrintStream l_out = new PrintStream(new FileOutputStream(nomFichier));
                        while(rs2.next())
                        {      
                            
                            l_out.println("place : " +rs2.getInt("place") + " | nom : " + rs2.getString("nomCoureur") + " | prenom : " + rs2.getString("prenomCoureur") + " | temps : " + rs2.getTime("temps")  );
                            
                        }
                        l_out.flush(); 
			l_out.close(); 
                    }
                  catch (Exception e)
                    {
                        System.out.println("Erreur Requete de chargement : " + e.getMessage());
                    }
                  
                }
            }
            
            catch (Exception e)
            {
                System.out.println("Erreur Requete de chargement : " + e.getMessage());
            }          
        }
       
        static public ObservableList<CoureurIndividuel> getCoureur()
        {
           Statement stmt;
           ResultSet rs; 
           CoureurIndividuel unCoureur;
           String pilote = "org.gjt.mm.mysql.Driver";
           String urle = new String("jdbc:mysql://localhost/projetjava");
           String requete = "select distinct prenomCoureur,nomCoureur from courir";
           try
            {
                Class.forName(pilote);
                Connection conn = DriverManager.getConnection(urle,"root","");
                stmt = conn.createStatement();
                rs = stmt.executeQuery(requete);
                while(rs.next())
                {
                 unCoureur = new CoureurIndividuel(rs.getString("prenomCoureur"),rs.getString("nomCoureur"));
                 lesCoureursClassement.add(unCoureur);
                }
            }
           catch (Exception e)
                    {
                        System.out.println("Erreur Requete de chargement : " + e.getMessage());
                    }
            return lesCoureursClassement;
        }
        
        static public ObservableList<ClassementCoureur> getCourseCoureur(String nomCoureur)
        {
           Statement stmt;
           ResultSet rs; 
           ClassementCoureur uneCourse;
           String pilote = "org.gjt.mm.mysql.Driver";
           String urle = new String("jdbc:mysql://localhost/projetjava");
           String requete = "select * from courir where nomCoureur='"+nomCoureur+"' order by place asc";
           System.out.println(requete);
           try
            {
                Class.forName(pilote);
                Connection conn = DriverManager.getConnection(urle,"root","");
                stmt = conn.createStatement();
                rs = stmt.executeQuery(requete);
                while(rs.next())
                {
                 uneCourse = new ClassementCoureur(rs.getString("nomCourse"),rs.getString("prenomCoureur"),rs.getString("nomCoureur"),rs.getInt("place"),rs.getTime("temps"));
                 lesCoursesCoureur.add(uneCourse);
                }
            }
           catch (Exception e)
                    {
                        System.out.println("Erreur Requete de chargement : " + e.getMessage());
                    }
           return lesCoursesCoureur;
        }
}
