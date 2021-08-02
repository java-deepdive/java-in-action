/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package kr.seok._4designing;

import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public class Camera {
    private Function<Color, Color> filter;

    public Camera() {
        setFilters();
    }

    //... other functions that use the filter ...

    public static void main(final String[] args) {
        final Camera camera = new Camera();
        final Consumer<String> printCaptured = (filterInfo) ->
                System.out.println(String.format("with %s: %s", filterInfo,
                        camera.capture(new Color(200, 100, 200))));

        System.out.println("//" + "START:NOFILTER_OUTPUT");
        printCaptured.accept("no filter");
        System.out.println("//" + "END:NOFILTER_OUTPUT");

        // 필터 추가
        System.out.println("//" + "START:BRIGHT_OUTPUT");
        camera.setFilters(Color::brighter);
        printCaptured.accept("brighter filter");
        System.out.println("//" + "END:BRIGHT_OUTPUT");

        System.out.println("//" + "START:DARK_OUTPUT");
        camera.setFilters(Color::darker);
        printCaptured.accept("darker filter");
        System.out.println("//" + "END:DARK_OUTPUT");

        System.out.println("//" + "START:BOTH_OUTPUT");
        camera.setFilters(Color::brighter, Color::darker);
        printCaptured.accept("brighter & darker filter");
        System.out.println("//" + "END:BOTH_OUTPUT");
    }

    public Color capture(final Color inputColor) {
        final Color processedColor = filter.apply(inputColor);
        //... more processing of color...
        return processedColor;
    }

    public void setFilters(final Function<Color, Color>... filters) {
        filter =
                Stream.of(filters)
                        .reduce((filter, next) -> filter.compose(next))
                        .orElse(color -> color)
//                        .orElseGet(Function::identity)
        ;
    }

}
