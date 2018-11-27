package bandasgrails

class Local {
    String nome
    Integer capacidade
    static hasMany = [show:Show]
    static constraints = {
    }
}
