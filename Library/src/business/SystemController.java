package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;

	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();

	}
	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}

	public void addNewMember(LibraryMember per){
		DataAccess da = new DataAccessFacade();
		da.saveNewMember(per);
	}

	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}
<<<<<<< HEAD

=======
	
>>>>>>> 477ddb6e28fe8d3ecf40382b655c96cb83ac1354
	@Override
	public int addBookCopy(String isbn) throws AuthException, NotExsitsException{
		System.out.println(this.currentAuth);
		if(null == this.currentAuth || this.currentAuth == Auth.LIBRARIAN) {
			throw new AuthException();
		}
<<<<<<< HEAD

=======
		
>>>>>>> 477ddb6e28fe8d3ecf40382b655c96cb83ac1354
		DataAccess da = new DataAccessFacade();
		HashMap<String, Book> map = da.readBooksMap();
		if(!map.containsKey(isbn)) {
			throw new NotExsitsException();
		}
<<<<<<< HEAD

		Book book = map.get(isbn);
		book.addCopy();

		da.saveBook(book);

		return book.getNumCopies();
	}


=======
		
		Book book = map.get(isbn);
		book.addCopy();
		
		da.saveBook(book);
		
		return book.getNumCopies();
	}
	
	
>>>>>>> 477ddb6e28fe8d3ecf40382b655c96cb83ac1354
}
