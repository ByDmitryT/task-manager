
package ru.titov.taskmanagerserver.endpoint.task;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.titov.taskmanagerserver.endpoint.task package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Create_QNAME = new QName("http://task.endpoint.taskmanagerserver.titov.ru/", "create");
    private final static QName _CreateResponse_QNAME = new QName("http://task.endpoint.taskmanagerserver.titov.ru/", "createResponse");
    private final static QName _Remove_QNAME = new QName("http://task.endpoint.taskmanagerserver.titov.ru/", "remove");
    private final static QName _RemoveResponse_QNAME = new QName("http://task.endpoint.taskmanagerserver.titov.ru/", "removeResponse");
    private final static QName _Update_QNAME = new QName("http://task.endpoint.taskmanagerserver.titov.ru/", "update");
    private final static QName _UpdateResponse_QNAME = new QName("http://task.endpoint.taskmanagerserver.titov.ru/", "updateResponse");
    private final static QName _View_QNAME = new QName("http://task.endpoint.taskmanagerserver.titov.ru/", "view");
    private final static QName _ViewAll_QNAME = new QName("http://task.endpoint.taskmanagerserver.titov.ru/", "viewAll");
    private final static QName _ViewAllResponse_QNAME = new QName("http://task.endpoint.taskmanagerserver.titov.ru/", "viewAllResponse");
    private final static QName _ViewResponse_QNAME = new QName("http://task.endpoint.taskmanagerserver.titov.ru/", "viewResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.titov.taskmanagerserver.endpoint.task
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new Remove();
    }

    /**
     * Create an instance of {@link RemoveResponse }
     * 
     */
    public RemoveResponse createRemoveResponse() {
        return new RemoveResponse();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link UpdateResponse }
     * 
     */
    public UpdateResponse createUpdateResponse() {
        return new UpdateResponse();
    }

    /**
     * Create an instance of {@link View }
     * 
     */
    public View createView() {
        return new View();
    }

    /**
     * Create an instance of {@link ViewAll }
     * 
     */
    public ViewAll createViewAll() {
        return new ViewAll();
    }

    /**
     * Create an instance of {@link ViewAllResponse }
     * 
     */
    public ViewAllResponse createViewAllResponse() {
        return new ViewAllResponse();
    }

    /**
     * Create an instance of {@link ViewResponse }
     * 
     */
    public ViewResponse createViewResponse() {
        return new ViewResponse();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link TaskListResponse }
     * 
     */
    public TaskListResponse createTaskListResponse() {
        return new TaskListResponse();
    }

    /**
     * Create an instance of {@link SimpleTask }
     * 
     */
    public SimpleTask createSimpleTask() {
        return new SimpleTask();
    }

    /**
     * Create an instance of {@link TaskResponse }
     * 
     */
    public TaskResponse createTaskResponse() {
        return new TaskResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://task.endpoint.taskmanagerserver.titov.ru/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://task.endpoint.taskmanagerserver.titov.ru/", name = "createResponse")
    public JAXBElement<CreateResponse> createCreateResponse(CreateResponse value) {
        return new JAXBElement<CreateResponse>(_CreateResponse_QNAME, CreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Remove }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://task.endpoint.taskmanagerserver.titov.ru/", name = "remove")
    public JAXBElement<Remove> createRemove(Remove value) {
        return new JAXBElement<Remove>(_Remove_QNAME, Remove.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://task.endpoint.taskmanagerserver.titov.ru/", name = "removeResponse")
    public JAXBElement<RemoveResponse> createRemoveResponse(RemoveResponse value) {
        return new JAXBElement<RemoveResponse>(_RemoveResponse_QNAME, RemoveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://task.endpoint.taskmanagerserver.titov.ru/", name = "update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://task.endpoint.taskmanagerserver.titov.ru/", name = "updateResponse")
    public JAXBElement<UpdateResponse> createUpdateResponse(UpdateResponse value) {
        return new JAXBElement<UpdateResponse>(_UpdateResponse_QNAME, UpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link View }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://task.endpoint.taskmanagerserver.titov.ru/", name = "view")
    public JAXBElement<View> createView(View value) {
        return new JAXBElement<View>(_View_QNAME, View.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://task.endpoint.taskmanagerserver.titov.ru/", name = "viewAll")
    public JAXBElement<ViewAll> createViewAll(ViewAll value) {
        return new JAXBElement<ViewAll>(_ViewAll_QNAME, ViewAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://task.endpoint.taskmanagerserver.titov.ru/", name = "viewAllResponse")
    public JAXBElement<ViewAllResponse> createViewAllResponse(ViewAllResponse value) {
        return new JAXBElement<ViewAllResponse>(_ViewAllResponse_QNAME, ViewAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://task.endpoint.taskmanagerserver.titov.ru/", name = "viewResponse")
    public JAXBElement<ViewResponse> createViewResponse(ViewResponse value) {
        return new JAXBElement<ViewResponse>(_ViewResponse_QNAME, ViewResponse.class, null, value);
    }

}
