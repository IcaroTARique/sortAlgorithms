import com.sort.Service;
import com.sort.algorithm.Insertion;
import com.sort.algorithm.Merge;
import com.sort.algorithm.Selection;
import com.sort.algorithm.contract.Sort;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Sort> sortMethodList = new ArrayList<>(List.of(
                new Insertion(),
                new Selection(),
                new Merge()
        ));

        sortMethodList.stream().forEach(e -> new Service(e).toSort());
    }
}
