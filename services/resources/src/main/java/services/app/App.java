/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package services.app;

import services.list.LinkedList;

import static services.utilities.StringUtils.join;
import static services.utilities.StringUtils.split;
import static services.app.MessageUtils.getMessage;

import org.apache.commons.text.WordUtils;

public class App {
    public static void main(String[] args) {
        LinkedList tokens;
        tokens = split(getMessage());
        String result = join(tokens);
        System.out.println(WordUtils.capitalize(result));
    }
}