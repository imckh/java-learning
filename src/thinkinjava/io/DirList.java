package thinkinjava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        String name = "i";

        if (name == "") {
            list = path.list();
        } else {
            //list = path.list(new DitFilter(name));
            list = path.list((dir, name1) -> {
                Pattern pattern = Pattern.compile(name1);
                return pattern.matcher(name1).find();
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(list));
    }

    // 使用lambda代替
    private static class DitFilter implements FilenameFilter {
        private Pattern pattern;
        public DitFilter(String name) {
            pattern = Pattern.compile(name);
        }

        @Override
        public boolean accept(File dir, String name) {
            return pattern.matcher(name).find();
        }
    }
}
