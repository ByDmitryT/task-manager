package ru.titov.taskmanagerserver.endpoint.project;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-01-16T18:22:34.820+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://project.endpoint.taskmanagerserver.titov.ru/", name = "ProjectEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface ProjectEndpoint {

    @WebMethod
    @Action(input = "http://project.endpoint.taskmanagerserver.titov.ru/ProjectEndpoint/removeRequest", output = "http://project.endpoint.taskmanagerserver.titov.ru/ProjectEndpoint/removeResponse")
    @RequestWrapper(localName = "remove", targetNamespace = "http://project.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.project.Remove")
    @ResponseWrapper(localName = "removeResponse", targetNamespace = "http://project.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.project.RemoveResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.titov.taskmanagerserver.endpoint.project.Response remove(
        @WebParam(name = "token", targetNamespace = "")
        java.lang.String token,
        @WebParam(name = "projectOrderIndex", targetNamespace = "")
        java.lang.Integer projectOrderIndex
    );

    @WebMethod
    @Action(input = "http://project.endpoint.taskmanagerserver.titov.ru/ProjectEndpoint/viewAllRequest", output = "http://project.endpoint.taskmanagerserver.titov.ru/ProjectEndpoint/viewAllResponse")
    @RequestWrapper(localName = "viewAll", targetNamespace = "http://project.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.project.ViewAll")
    @ResponseWrapper(localName = "viewAllResponse", targetNamespace = "http://project.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.project.ViewAllResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.titov.taskmanagerserver.endpoint.project.ProjectListResponse viewAll(
        @WebParam(name = "token", targetNamespace = "")
        java.lang.String token
    );

    @WebMethod
    @Action(input = "http://project.endpoint.taskmanagerserver.titov.ru/ProjectEndpoint/viewRequest", output = "http://project.endpoint.taskmanagerserver.titov.ru/ProjectEndpoint/viewResponse")
    @RequestWrapper(localName = "view", targetNamespace = "http://project.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.project.View")
    @ResponseWrapper(localName = "viewResponse", targetNamespace = "http://project.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.project.ViewResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.titov.taskmanagerserver.endpoint.project.ProjectResponse view(
        @WebParam(name = "token", targetNamespace = "")
        java.lang.String token,
        @WebParam(name = "projectOrderIndex", targetNamespace = "")
        java.lang.Integer projectOrderIndex
    );

    @WebMethod
    @Action(input = "http://project.endpoint.taskmanagerserver.titov.ru/ProjectEndpoint/updateRequest", output = "http://project.endpoint.taskmanagerserver.titov.ru/ProjectEndpoint/updateResponse")
    @RequestWrapper(localName = "update", targetNamespace = "http://project.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.project.Update")
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://project.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.project.UpdateResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.titov.taskmanagerserver.endpoint.project.Response update(
        @WebParam(name = "token", targetNamespace = "")
        java.lang.String token,
        @WebParam(name = "projectOrderIndex", targetNamespace = "")
        java.lang.Integer projectOrderIndex,
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    );

    @WebMethod
    @Action(input = "http://project.endpoint.taskmanagerserver.titov.ru/ProjectEndpoint/createRequest", output = "http://project.endpoint.taskmanagerserver.titov.ru/ProjectEndpoint/createResponse")
    @RequestWrapper(localName = "create", targetNamespace = "http://project.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.project.Create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://project.endpoint.taskmanagerserver.titov.ru/", className = "ru.titov.taskmanagerserver.endpoint.project.CreateResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.titov.taskmanagerserver.endpoint.project.Response create(
        @WebParam(name = "token", targetNamespace = "")
        java.lang.String token,
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    );
}
