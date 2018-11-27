package bandasgrails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LocalServiceSpec extends Specification {

    LocalService localService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Local(...).save(flush: true, failOnError: true)
        //new Local(...).save(flush: true, failOnError: true)
        //Local local = new Local(...).save(flush: true, failOnError: true)
        //new Local(...).save(flush: true, failOnError: true)
        //new Local(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //local.id
    }

    void "test get"() {
        setupData()

        expect:
        localService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Local> localList = localService.list(max: 2, offset: 2)

        then:
        localList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        localService.count() == 5
    }

    void "test delete"() {
        Long localId = setupData()

        expect:
        localService.count() == 5

        when:
        localService.delete(localId)
        sessionFactory.currentSession.flush()

        then:
        localService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Local local = new Local()
        localService.save(local)

        then:
        local.id != null
    }
}
