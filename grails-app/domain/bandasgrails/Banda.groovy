package bandasgrails

class Banda {

    String nome
    BandaEnum bandaEnum


    static hasMany = [show:Show]
    static belongsTo =  Show

    static constraints = {
        bandaEnum blank : false
    }

    String toString() {
        return "${bandaEnum}"
    }
}

