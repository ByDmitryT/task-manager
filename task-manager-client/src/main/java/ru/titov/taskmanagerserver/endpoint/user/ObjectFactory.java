
package ru.titov.taskmanagerserver.endpoint.user;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.titov.taskmanagerserver.endpoint.user package. 
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

    private final static QName _ChangePassword_QNAME = new QName("http://user.endpoint.taskmanagerserver.titov.ru/", "changePassword");
    private final static QName _ChangePasswordResponse_QNAME = new QName("http://user.endpoint.taskmanagerserver.titov.ru/", "changePasswordResponse");
    private final static QName _SignIn_QNAME = new QName("http://user.endpoint.taskmanagerserver.titov.ru/", "signIn");
    private final static QName _SignInResponse_QNAME = new QName("http://user.endpoint.taskmanagerserver.titov.ru/", "signInResponse");
    private final static QName _SignUp_QNAME = new QName("http://user.endpoint.taskmanagerserver.titov.ru/", "signUp");
    private final static QName _SignUpResponse_QNAME = new QName("http://user.endpoint.taskmanagerserver.titov.ru/", "signUpResponse");
    private final static QName _ViewAll_QNAME = new QName("http://user.endpoint.taskmanagerserver.titov.ru/", "viewAll");
    private final static QName _ViewAllResponse_QNAME = new QName("http://user.endpoint.taskmanagerserver.titov.ru/", "viewAllResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.titov.taskmanagerserver.endpoint.user
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChangePassword }
     * 
     */
    public ChangePassword createChangePassword() {
        return new ChangePassword();
    }

    /**
     * Create an instance of {@link ChangePasswordResponse }
     * 
     */
    public ChangePasswordResponse createChangePasswordResponse() {
        return new ChangePasswordResponse();
    }

    /**
     * Create an instance of {@link SignIn }
     * 
     */
    public SignIn createSignIn() {
        return new SignIn();
    }

    /**
     * Create an instance of {@link SignInResponse }
     * 
     */
    public SignInResponse createSignInResponse() {
        return new SignInResponse();
    }

    /**
     * Create an instance of {@link SignUp }
     * 
     */
    public SignUp createSignUp() {
        return new SignUp();
    }

    /**
     * Create an instance of {@link SignUpResponse }
     * 
     */
    public SignUpResponse createSignUpResponse() {
        return new SignUpResponse();
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
     * Create an instance of {@link TokenResponse }
     * 
     */
    public TokenResponse createTokenResponse() {
        return new TokenResponse();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link UserListResponse }
     * 
     */
    public UserListResponse createUserListResponse() {
        return new UserListResponse();
    }

    /**
     * Create an instance of {@link SimpleUser }
     * 
     */
    public SimpleUser createSimpleUser() {
        return new SimpleUser();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.endpoint.taskmanagerserver.titov.ru/", name = "changePassword")
    public JAXBElement<ChangePassword> createChangePassword(ChangePassword value) {
        return new JAXBElement<ChangePassword>(_ChangePassword_QNAME, ChangePassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangePasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.endpoint.taskmanagerserver.titov.ru/", name = "changePasswordResponse")
    public JAXBElement<ChangePasswordResponse> createChangePasswordResponse(ChangePasswordResponse value) {
        return new JAXBElement<ChangePasswordResponse>(_ChangePasswordResponse_QNAME, ChangePasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.endpoint.taskmanagerserver.titov.ru/", name = "signIn")
    public JAXBElement<SignIn> createSignIn(SignIn value) {
        return new JAXBElement<SignIn>(_SignIn_QNAME, SignIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignInResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.endpoint.taskmanagerserver.titov.ru/", name = "signInResponse")
    public JAXBElement<SignInResponse> createSignInResponse(SignInResponse value) {
        return new JAXBElement<SignInResponse>(_SignInResponse_QNAME, SignInResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignUp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.endpoint.taskmanagerserver.titov.ru/", name = "signUp")
    public JAXBElement<SignUp> createSignUp(SignUp value) {
        return new JAXBElement<SignUp>(_SignUp_QNAME, SignUp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignUpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.endpoint.taskmanagerserver.titov.ru/", name = "signUpResponse")
    public JAXBElement<SignUpResponse> createSignUpResponse(SignUpResponse value) {
        return new JAXBElement<SignUpResponse>(_SignUpResponse_QNAME, SignUpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.endpoint.taskmanagerserver.titov.ru/", name = "viewAll")
    public JAXBElement<ViewAll> createViewAll(ViewAll value) {
        return new JAXBElement<ViewAll>(_ViewAll_QNAME, ViewAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://user.endpoint.taskmanagerserver.titov.ru/", name = "viewAllResponse")
    public JAXBElement<ViewAllResponse> createViewAllResponse(ViewAllResponse value) {
        return new JAXBElement<ViewAllResponse>(_ViewAllResponse_QNAME, ViewAllResponse.class, null, value);
    }

}
