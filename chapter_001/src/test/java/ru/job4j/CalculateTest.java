package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Svetlana Ragulina (alistern22@gmail.com)
* @version $Id$
* @since 0.1
*/
public class CalculateTest {
/*
* Test echo.
*/ 
@Test
public void whenTakeNameThenThreeEchoPlusName() {
	String input = "Svetlana Ragulina";
	String expect = "Echo, echo, echo : Svetlana Ragulina";
	// Создание нового объекта.
	Calculate calc = new Calculate();
	// Выполнение метода echo с параметром input и запись ее в переменную result.
	String result = calc.echo(input);
	assertThat(result, is(expect));
}
}