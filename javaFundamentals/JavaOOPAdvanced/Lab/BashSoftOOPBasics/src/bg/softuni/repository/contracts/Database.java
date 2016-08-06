package bg.softuni.repository.contracts;

import java.io.IOException;

public interface Database extends FilteredTaker, OrderedTaker, Requester {

    void loadData(String fileName) throws IOException;

    void unloadData();

}
