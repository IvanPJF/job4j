package ru.job4j.inputoutput;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test.
 * Socket.
 * Server.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 18.02.2019
 *@version 0.1
 */
public class ServerTest {

    private static final String LN = System.lineSeparator();

    /**
     * Tests a socket with input parameters.
     * @param input Incoming commands.
     * @param expected Expected result.
     * @throws IOException IOException.
     */
    public void testSocket(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.run();
        assertThat(out.toString(), is(expected));
    }

    /**
     * Incoming command - exit.
     * @throws IOException IOException.
     */
    @Test
    public void whenAskIsExitThenAnswerIsEmpty() throws IOException {
        String input = "exit";
        String expected = "";
        this.testSocket(input, expected);
    }

    /**
     * Incoming command - any unsupported.
     * @throws IOException IOException.
     */
    @Test
    public void whenAskIsUnsupportedThenAnswerIsDontUnderstand() throws IOException {
        String input = Joiner.on(LN).join("Unsupported ask", "exit");
        String expected = Joiner.on(LN).join("I don't understand you.", "", "");
        this.testSocket(input, expected);
    }

    /**
     * Incoming command - hello.
     * @throws IOException IOException.
     */
    @Test
    public void whenAskIsHelloThenAnswerIsHelloDearFriend() throws IOException {
        String input = Joiner.on(LN).join("hello", "exit");
        String expected = Joiner.on(LN).join("Hello, dear friend. I'm a oracle.", "", "");
        this.testSocket(input, expected);
    }
}