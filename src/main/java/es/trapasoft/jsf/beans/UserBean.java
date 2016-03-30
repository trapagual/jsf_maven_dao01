/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package es.trapasoft.jsf.beans;


import es.trapasoft.jsf.dao.DAOFactory;
import es.trapasoft.jsf.dao.ProjectDAO;
import es.trapasoft.jsf.dao.UserDAO;
import es.trapasoft.jsf.models.Project;
import es.trapasoft.jsf.models.User;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author alejandro
 */
@ManagedBean
@ViewScoped
public class UserBean {

    private DAOFactory javabase;
    private UserDAO userDAO;
    private List<User> users;
    private List<Project> projects;
    
    private User selectedUser;
    private Project selectedUserProject;
    private ProjectDAO projectDAO;
    
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }
    
    @PostConstruct
    public void init() {
        javabase = DAOFactory.getInstance("javabase.jdbc");
        userDAO = javabase.getUserDAO();
        users = userDAO.list();
    }
    
    
    /* ------------- GETTERS / SETTERS ----------------- */

    public List<User> getUsers() {
        return users;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
        projectDAO = javabase.getProjectDAO();
        // MAL AQUI HAY QUE RELLENAR LOS PROYECTOS DEL USUARIO   projects = projectDAO.findUsersByProjectId(selectedUser.getId());
        projects = userDAO.findProjectsByUserId(selectedUser.getId());
    }

    public Project getSelectedUserProject() {
        return selectedUserProject;
    }

    public List<Project> getProjects() {
        return projects;
    }
    
}
