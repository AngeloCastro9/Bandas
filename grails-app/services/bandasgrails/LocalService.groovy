package bandasgrails

import grails.gorm.services.Service

@Service(Local)
interface LocalService {

    Local get(Serializable id)

    List<Local> list(Map args)

    Long count()

    void delete(Serializable id)

    Local save(Local local)

}