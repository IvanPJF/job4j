package ru.job4j.inputoutput;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test.
 * Socket.
 * Client.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 19.02.2019
 *@version 0.1
 */
public class ClientTest {

    private static final String LN = System.lineSeparator();

    /**
     * Tests a socket with input parameters.
     * @param inConsole The request is entered in the console.
     * @param inSocket Information from the incoming stream.
     * @param expected The overall output to the client console.
     * @throws IOException IOException.
     */
    public void testSocket(String inConsole, String inSocket, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(inSocket.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        ByteArrayInputStream reader = new ByteArrayInputStream(inConsole.getBytes());
        ByteArrayOutputStream outConsole = new ByteArrayOutputStream();
        System.setIn(reader);
        System.setOut(new PrintStream(outConsole));
        Client client = new Client(socket);
        client.run();
        assertThat(out.toString(), is(inConsole));
        assertThat(outConsole.toString(), is(expected));
    }

    /**
     * Command - exit.
     * @throws IOException IOException.
     */
    @Test
    public void whenAskIsExitThenAnswerIsEmpty() throws IOException {
        String inConsole = Joiner.on(LN).join("exit", "");
        String inSocket = "";
        String expected = Joiner.on(LN).join("Enter a message to the server: ", "");
        this.testSocket(inConsole, inSocket, expected);
    }

    /**
     * Command - any words.
     * @throws IOException IOException.
     */
    @Test
    public void whenAskIsUnsupportedThenAnswerIsDontUnderstand() throws IOException {
        String inConsole = Joiner.on(LN).join("All any words", "exit", "");
        String inSocket = Joiner.on(LN).join("I don't understand you.", "");
        String expected = Joiner.on(LN).join(
                "Enter a message to the server: ",
                "I don't understand you.",
                "Enter a message to the server: ",
                ""
        );
        this.testSocket(inConsole, inSocket, expected);
    }
}