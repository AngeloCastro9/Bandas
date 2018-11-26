package bandasgrails

class Local {
    String nome
    int capacidade
    static hasMany = [show:Show]
    static constraints = {
    }
}
