package sample.noyeau ;

abstract class Authentification {
    protected String login;
    protected String motdepasse;

    abstract void creerCompte();
    abstract void seConnecter();
}
