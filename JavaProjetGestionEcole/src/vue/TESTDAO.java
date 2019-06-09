/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import controleur.*;
import modele.*;

/**
 *
 * @author Marine
 */
public class TESTDAO {

    /**
     *
     */
    public static void test_dao_ecole(){
            UnitTest test = new UnitTest("test_dao_ecole");

            DAO<Ecole> dao = DAO_Factory.getEcoleDAO();

            Ecole new_school = new Ecole(1, "DAO_test_ecole");
            try {
                dao.create(new_school);

                Ecole school = dao.find(1); //Les Ids commencent a 1 dans la table MySQL.
                test.assert_String(school.getNom(), "DAO_test_ecole");
            } catch (Exception e){
                test.error();
            }

            test.success();
        }

    /**
     *
     */
    public static void test_dao_anneescolaire(){
            UnitTest test = new UnitTest("test_dao_anneescolaire");

            DAO<AnneeScolaire> dao = DAO_Factory.getAnneeScolaireDAO();

            AnneeScolaire new_annee = new AnneeScolaire(1);

            try {
                dao.create(new_annee);

                AnneeScolaire annee = dao.find(1);
                test.assert_int(annee.getId(), new_annee.getId());
                test.assert_int(annee.getId(), 1);
            } catch (Exception e) {
                test.error();
            }

            test.success();
        }

    /**
     *
     */
    public static void test_dao_bulletin(){
            UnitTest test = new UnitTest("test_dao_bulletin()");

            DAO<Bulletin> dao = DAO_Factory.getBulletinDAO();

            Bulletin new_bulletin = new Bulletin(1, "DAO BULLETIN", "DAO_test_bulletin()", 1, 1);

            try {
                dao.create(new_bulletin);

                Bulletin bulletin = dao.find(1);
                test.assert_String(bulletin.getAppreciation(), "DAO_test_bulletin()");
                test.assert_int(bulletin.getId_Trimestre(), 1);
                test.assert_int(bulletin.getId_Inscription(), 1);
            } catch (Exception e) {
                test.error();
            }

            test.success();
        }

    /**
     *
     */
    public static void test_dao_classe(){
            UnitTest test = new UnitTest("test_dao_classe()");

            DAO<Classe> dao = DAO_Factory.getClasseDAO();

            Classe new_bulletin = new Classe(1, "DAO_test_classe()", 1, 1, 1);

            try {
                dao.create(new_bulletin);

                Classe classe = dao.find(1);
                test.assert_String(classe.getNom(), "DAO_test_classe()");
                test.assert_int(classe.getId_AnneeScolaire(), 1);
                test.assert_int(classe.getId_Ecole(), 1);
                test.assert_int(classe.getId_Niveau(), 1);
            } catch (Exception e) {
                test.error();
            }

            test.success();
        }

    /**
     *
     */
    public static void test_dao_detailbulletin(){
            UnitTest test = new UnitTest("test_dao_detailbulletin()");

            DAO<DetailBulletin> dao = DAO_Factory.getDetailBulletinDAO();

            DetailBulletin new_bulletin = new DetailBulletin(1, "DAO_test_detailbulletin()", 1, 1);

            try {
                dao.create(new_bulletin);

                DetailBulletin detailbulletin = dao.find(1);
                test.assert_String(detailbulletin.getAppreciation(), "DAO_test_detailbulletin()");
                test.assert_int(detailbulletin.getId_Bulletin(), 1);
                test.assert_int(detailbulletin.getId_Enseignement(), 1);
            } catch (Exception e) {
                test.error();
            }

            test.success();
        }

    /**
     *
     */
    public static void test_dao_discipline(){
            UnitTest test = new UnitTest("test_dao_discipline()");

            DAO<Discipline> dao = DAO_Factory.getDisciplineDAO();

            Discipline new_T = new Discipline(1, "DAO_test_discipline()");

            try {
                dao.create(new_T);

                Discipline T = dao.find(1);
                test.assert_String(T.getNom(), "DAO_test_discipline()");
                test.assert_int(T.getId(), 1);
            } catch (Exception e) {
                test.error();
            }

            test.success();
        }

    /**
     *
     */
    public static void test_dao_enseignement(){
            UnitTest test = new UnitTest("test_dao_enseignement()");

            DAO<Enseignement> dao = DAO_Factory.getEnseignementDAO();

            Enseignement new_T = new Enseignement(1, 1, 1, 1);

            try {
                dao.create(new_T);

                Enseignement T = dao.find(1);
                test.assert_int(T.getId_Classe(), 1);
                test.assert_int(T.getId_Discipline(), 1);
                test.assert_int(T.getId_Personne(), 1);
                test.assert_int(T.getId(), 1);
            } catch (Exception e) {
                test.error();
            }

            test.success();
        }

    /**
     *
     */
    public static void test_dao_evaluation(){
            UnitTest test = new UnitTest("test_dao_evaluation()");

            DAO<Evaluation> dao = DAO_Factory.getEvaluationDAO();

            Evaluation new_T = new Evaluation(1, 1, "DAO_test_evaluation()", 1);

            try {
                dao.create(new_T);

                Evaluation T = dao.find(1);
                test.assert_double(T.getNote(), 1);
                test.assert_String(T.getAppreciation(), "DAO_test_evaluation()");
                test.assert_int(T.getId_DetailBulletin(), 1);
                test.assert_int(T.getId(), 1);
            } catch (Exception e) {
                test.error();
            }

            test.success();
        }

    /**
     *
     */
    public static void test_dao_inscription(){
            UnitTest test = new UnitTest("test_dao_inscription()");

            DAO<Inscription> dao = DAO_Factory.getInscriptionDAO();

            Inscription new_T = new Inscription(1, 1, 1);

            try {
                dao.create(new_T);

                Inscription T = dao.find(1);
                test.assert_int(T.getId_Classe(), 1);
                test.assert_int(T.getId_Personne(), 1);
                test.assert_int(T.getId(), 1);
            } catch (Exception e) {
                test.error();
            }

            test.success();
        }

    /**
     *
     */
    public static void test_dao_niveau(){
            UnitTest test = new UnitTest("test_dao_niveau()");

            DAO<Niveau> dao = DAO_Factory.getNiveauDAO();

            Niveau new_T = new Niveau(1, "DAO_test_niveau()");

            try {
                dao.create(new_T);

                Niveau T = dao.find(1);
                test.assert_String(T.getNom(), "DAO_test_niveau()");
                test.assert_int(T.getId(), 1);
            } catch (Exception e) {
                test.error();
            }

            test.success();
        }

    /**
     *
     */
    public static void test_dao_personne(){
            UnitTest test = new UnitTest("test_dao_personne()");

            DAO<Personne> dao = DAO_Factory.getPersonneDAO();

            Personne new_T = new Personne(1, "Spoutnik", "Danu",
                            "schtoblyat", "op@chki", 0);

            try {
                dao.create(new_T);

                Personne T = dao.find(1);
                test.assert_String(T.getNom(), "Spoutnik");
                test.assert_String(T.getPrenom(), "Danu");
                test.assert_String(T.getLogin(), "schtoblyat");
                test.assert_String(T.getPassword(), "op@chki");
                //test.assert_boolean(T.getType_Enseignant(), true);
                test.assert_int(T.getId(), 1);
            } catch (Exception e) {
                test.error();
            }

            test.success();
        }

    /**
     *
     */
    public static void test_dao_trimestre(){
            UnitTest test = new UnitTest("test_dao_trimestre()");

            DAO<Trimestre> dao = DAO_Factory.getTrimestreDAO();

            Trimestre new_T = new Trimestre(1, 1, 1, 1, 1);

            try {
                dao.create(new_T);

                Trimestre T = dao.find(1);
                test.assert_int(T.getNumero(), 1);
                test.assert_int(T.getDebut(), 1);
                test.assert_int(T.getFin(), 1);
                test.assert_int(T.getId_AnneeScolaire(), 1);
                test.assert_int(T.getId(), 1);
            } catch (Exception e) {
                test.error();
            }

            test.success();
        }

    /**
     *
     */
    public static void dao_test_suite(){
            test_dao_ecole();
            test_dao_anneescolaire();
            test_dao_niveau();
            test_dao_personne();
            test_dao_discipline();
            test_dao_classe();
            test_dao_trimestre();
            test_dao_inscription();
            test_dao_enseignement();
            test_dao_bulletin();
            test_dao_detailbulletin();
            test_dao_evaluation();
        }

    /**
     *
     * @param args
     */
    public static void tests(String[] args){
            dao_test_suite();
        }
}
