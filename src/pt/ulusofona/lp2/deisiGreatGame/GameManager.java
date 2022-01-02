package pt.ulusofona.lp2.deisiGreatGame;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.swing.*;


public class GameManager {

    Programmer currentPlayer;
    TreeMap<Integer, Square> boardMap = new TreeMap<>();
    private final List<Programmer> programmers = new ArrayList<>();
    List<Tool> boardTool = new ArrayList<>();
    List<Abyss> boardAbyss = new ArrayList<>();
    ProgrammerColor color;
    private Node head = null;
    private Node tail = null;
    private int nrTurnos = 1;
    private int dado = 0;


    public GameManager() {}

    public Abyss checkAbyss(int id, int pos) {
        switch (id) {
            case 0 -> {
                return new Syntax(0,id, pos);
            }
            case 1 -> {
                return new Logic(0,id, pos);
            }
            case 2 -> {
                return new ExceptionAbyss(0,id, pos);
            }
            case 3 -> {
                return new FileNotFound(0,id, pos);
            }
            case 4 -> {
                return new Crash(0,id, pos);
            }
            case 5 -> {
                return new DuplicatedCode(0,id, pos);
            }
            case 6 -> {
                return new SideEffects(0,id, pos);
            }
            case 7 -> {
                return new BlueScreen(0,id, pos);
            }
            case 8 -> {
                return new Loop(0,id, pos);
            }
            case 9 -> {
                return new SegmentationFault(0,id, pos);
            }
            default ->  {
                return null;
            }
        }

    }

    public Tool checkTool(int id, int pos, String title) {
        if (title.equals("")) {
            switch (id) {
                case 0 -> {
                    return new Inheritance(1, id, pos);
                }
                case 1 -> {
                    return new Functional(1, id, pos);
                }
                case 2 -> {
                    return new UnitTests(1, id, pos);
                }
                case 3 -> {
                    return new Catch(1, id, pos);
                }
                case 4 -> {
                    return new Ide(1, id, pos);
                }
                case 5 -> {
                    return new TeachersHelp(1, id, pos);
                }
                default -> {
                    return null;
                }
            }
        } else {
            switch (title) {
                case "Herança" -> {
                    return new Inheritance(1, 0, pos);
                }
                case "Programação Funcional" -> {
                    return new Functional(1, 1, pos);
                }
                case "Testes unitários" -> {
                    return new UnitTests(1, 2, pos);
                }
                case "Tratamento de Excepções" -> {
                    return new Catch(1, 3, pos);
                }
                case "IDE" -> {
                    return new Ide(1, 4, pos);
                }
                case "Ajuda Do Professor" -> {
                    return new TeachersHelp(1, 5, pos);
                }
                default -> {
                    return null;
                }
            }
        }

    }

    public boolean saveGame(File file){
        FileWriter fw = null;
        try {
            if(!file.canWrite()){
                return false;
            }
            fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(""+programmers.size() + "\n");
            bw.write(""+(boardTool.size() + boardAbyss.size()) + "\n");
            bw.write("Player: " + head.getProgrammer().toStringToFile() +"\n");
            if(head.next != tail){
                bw.write("Player: " + head.next.getProgrammer().toStringToFile() +"\n");
            }
            if(head.next.next != tail){
                bw.write("Player: " +head.next.next.getProgrammer().toStringToFile() +"\n");
            }
            bw.write("Player: "+tail.getProgrammer().toStringToFile() +"\n");
            for(Tool tool : boardTool ){
                bw.write("Tool: " + tool.getId() + "," +tool.getPos()+ "\n");
            }
            for(Abyss abyss : boardAbyss){
                bw.write("Abyss: "+abyss.getId() +","+abyss.getPos() + "\n");
            }
            bw.write("BoardSize: "+boardMap.size() + "\n");
            bw.write("Turnos: "+nrTurnos);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean loadGame(File file) throws IOException{

        Scanner sc = null;
        try {
            if(!file.canRead()){
                return false;
            }
            sc = new Scanner(file);
            int boardSize = 0;
            int jogadores = Integer.parseInt(sc.nextLine());
            int abyssesAndToolsLenth = Integer.parseInt(sc.nextLine());
            int turnos = 0;
            List<Programmer> players = new ArrayList<>();
            String[][] playerInfo = new String[jogadores][4];
            String[][] abyssesAndTools = new String[abyssesAndToolsLenth][3];
            TreeSet<String> languages;

            boolean loop;
            boolean status;

            int x = 0;
            int y = 0;
            while (sc.hasNext()) {
                String line = sc.nextLine();
                List<Tool> tools = new ArrayList<>();
                if (line.startsWith("Player: ")) {

                    line = line.replace("Player: ", "");
                    String[] playerData = line.split("/");

                    playerInfo[x][0] = playerData[0];
                    playerInfo[x][1] = playerData[1];
                    playerInfo[x][2] = playerData[6];
                    playerInfo[x][3] = playerData[2];

                    if (!playerData[7].equals("No tools")) {

                        String[] toolsString = playerData[7].split(";");
                        for (String toolCheck : toolsString) {
                            Tool tool = checkTool(-1, -1, toolCheck);
                            tools.add(tool);
                        }
                    }
                    switch (playerData[2]) {
                        case "Green" -> color = ProgrammerColor.GREEN;
                        case "Blue" -> color = ProgrammerColor.BLUE;
                        case "Brown" -> color = ProgrammerColor.BROWN;
                        case "Purple" -> color = ProgrammerColor.PURPLE;
                    }
                    loop = !playerData[8].equals("No Loop");
                    status = !playerData[9].equals("Em Jogo");
                    String[] language = playerData[6].split(";");
                    languages = new TreeSet<>(Arrays.asList(language));
                    Programmer player = new Programmer(Integer.parseInt(playerData[0]),playerData[1],color,
                            Integer.parseInt(playerData[3]),Integer.parseInt(playerData[4]),
                            Integer.parseInt(playerData[5]),languages,tools,loop,status);
                    players.add(player);

                    x++;

                } else if (line.startsWith("Tool: ")) {
                    line = line.replace("Tool: ","");
                    String[] toolData = line.split(",");
                    abyssesAndTools[y][0] = "1";
                    abyssesAndTools[y][1] = toolData[0];
                    abyssesAndTools[y][2] = toolData[1];
                    y++;

                }else if(line.startsWith("Abyss: ")){
                    line = line.replace("Abyss: ","");
                    String[] abyssData = line.split(",");
                    abyssesAndTools[y][0] = "0";
                    abyssesAndTools[y][1] = abyssData[0];
                    abyssesAndTools[y][2] = abyssData[1];
                    y++;

                } else if (line.startsWith("BoardSize: ")) {
                    line = line.replace("BoardSize: ","");
                    boardSize = Integer.parseInt(line);
                }else if (line.startsWith("Turnos: ")) {
                    line = line.replace("Turnos: ","");
                    turnos = Integer.parseInt(line);
                }else{
                    return false;
                }

            }
            try {
                createInitialBoard(playerInfo,boardSize,abyssesAndTools);
            } catch (InvalidInitialBoardException e) {
                e.printStackTrace();
            }
            boardMap.get(1).getProgrammers().clear();
            if (head != null) {
                if (head.next.next != null && head.next.next != tail) {
                    head.next.next = null;
                }
                if (head.next != tail) {
                    head.next = null;
                }
                head = null;
                tail = null;
            }
            for (Programmer player : players) {
                Node newNode = new Node(player);
                if (head == null) {
                    head = newNode;
                } else {
                    tail.next = newNode;
                }
                tail = newNode;
                tail.next = head;
            }
            players.sort(Comparator.comparing(Programmer::getId));
            for(int i = 0;i<programmers.size();i++){
                programmers.set(i, players.get(i));
            }
            nrTurnos = turnos;
            for(Programmer programmer : programmers){
                boardMap.get(programmer.getPos()).addProgrammer(programmer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return true;
    }

    public void createInitialBoard(String[][] playerInfo, int boardSize) throws InvalidInitialBoardException{
        createInitialBoard(playerInfo, boardSize, null);

    }

    public void createInitialBoard(String[][] playerInfo, int boardSize, String[][] abyssesAndTools) throws InvalidInitialBoardException {
        String[] languages;
        boardMap.clear();
        boardTool.clear();
        boardAbyss.clear();
        currentPlayer = null;
        ProgrammerColor color = ProgrammerColor.PURPLE;
        programmers.clear();
        if (head != null) {
            if (head.next.next != null && head.next.next != tail) {
                head.next.next = null;
            }
            if (head.next != tail) {
                head.next = null;
            }
            head = null;
            tail = null;
        }
        nrTurnos = 1;

        int jogadores = playerInfo.length;


        if (jogadores <=1 || jogadores > 4) {
            throw new InvalidInitialBoardException("Numero Jogadores invalidos");
        }

        if (jogadores * 2 > boardSize) {
            throw new InvalidInitialBoardException("BoardSize insuficiente");
        }

        for (int x = 0; x < jogadores; x++) {

            if (playerInfo[x][1].equals("") || playerInfo[x][1] == null || playerInfo[x][1].equals(" ")) {
                throw new InvalidInitialBoardException("Nome Invalido");
            }

            if (!((playerInfo[x][3].equals(ProgrammerColor.GREEN.toString())) ||
                    (playerInfo[x][3].equals(ProgrammerColor.BROWN.toString()))
                    || (playerInfo[x][3].equals(ProgrammerColor.PURPLE.toString())) ||
                    (playerInfo[x][3].equals(ProgrammerColor.BLUE.toString())))) {
                throw new InvalidInitialBoardException("Cor Invalida");
            }

            if (Integer.parseInt(playerInfo[x][0]) < 0 || playerInfo[x][0] == null || playerInfo[x][0].equals("") || playerInfo[x][0].isEmpty()) {
                throw new InvalidInitialBoardException("ID Invalido");
            }

            if (playerInfo[x][2].equals("") || playerInfo[x][2] == null || playerInfo[x][2].equals(" ")) {
                throw new InvalidInitialBoardException("Linguagens Invalidas");
            }

            for (int y = x + 1; y < jogadores; y++) {
                if (playerInfo[x][0].equals(playerInfo[y][0])) {
                    throw new InvalidInitialBoardException("ID repetido");
                } else if (playerInfo[x][3].equals(playerInfo[y][3])) {
                    throw new InvalidInitialBoardException("Cor repetida");
                }
            }
        }

        for (String[] strings : playerInfo) {
            languages = strings[2].split(";");
            for (int b = 0; b < languages.length; b++) {
                languages[b] = languages[b].trim();
            }
            TreeSet<String> tree = new TreeSet<>(Arrays.asList(languages));
            switch (strings[3]) {
                case "Green" -> color = ProgrammerColor.GREEN;
                case "Blue" -> color = ProgrammerColor.BLUE;
                case "Brown" -> color = ProgrammerColor.BROWN;
                case "Purple" -> color = ProgrammerColor.PURPLE;
            }
            Programmer programmer = new Programmer(strings[1], Integer.parseInt(strings[0]), tree, color);
            programmers.add(programmer);
        }
        programmers.sort(Comparator.comparing(Programmer::getId));
        for (Programmer player : programmers) {

            Node newNode = new Node(player);
            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            tail.next = head;
        }

        boardMap.put(1, new Empty(1));
        for (Programmer programmer : programmers) {
            boardMap.get(1).addProgrammer(programmer);
        }

        for (int x = 2; x <= boardSize; x++) {
            boardMap.put(x, new Empty(x));
        }

        if(abyssesAndTools != null) {
            for (String[] abyssesAndTool : abyssesAndTools) {
                int checkID = Integer.parseInt(abyssesAndTool[1]);
                int checkPos = Integer.parseInt(abyssesAndTool[2]);

                if (abyssesAndTool[0].equals("0")) {
                    if (checkPos > 0 && checkPos <= boardSize) {
                        if(checkAbyss(checkID,checkPos) != null) {
                            Abyss abyss = checkAbyss(checkID,checkPos);
                            boardMap.put(checkPos, abyss);
                            boardAbyss.add(abyss);
                        } else {
                            throw new InvalidInitialBoardException("Abyss Invalido");
                        }
                    } else {
                        throw new InvalidInitialBoardException("Posição Invalida");
                    }
                } else if (abyssesAndTool[0].equals("1")) {
                    if (checkPos > 0 && checkPos <= boardSize) {
                        if(checkTool(checkID,checkPos, "")!= null) {
                            Tool tool = checkTool(checkID,checkPos,"");
                            boardMap.put(checkPos, tool);
                            boardTool.add(tool);
                        } else {
                            throw new InvalidInitialBoardException("Tool Invalida");
                        }
                    } else {
                        throw new InvalidInitialBoardException("Posição Invalida");
                    }
                } else {
                    throw new InvalidInitialBoardException("Não é tool nem abismo");
                }
            }
        }


}

    public String getImagePng(int position) {
        if (position < 1 || position > boardMap.size()) {
            return null;
        }
        if (position == boardMap.size()) {
            return "glory.png";
        }
        if(boardMap.containsKey(position)) {
            if (boardMap.get(position).getTitle() != null) {
                switch (boardMap.get(position).getTitle()) {
                    case "Herança" -> {
                        return "inheritance.png";
                    }
                    case "Programação Funcional" -> {
                        return "functional.png";
                    }
                    case "Testes unitários" -> {
                        return "unit-tests.png";
                    }
                    case "Tratamento de Excepções" -> {
                        return "catch.png";
                    }
                    case "IDE" -> {
                        return "IDE.png";
                    }
                    case "Ajuda Do Professor" -> {
                        return "ajuda-professor.png";
                    }
                    case "Erro de sintaxe" -> {
                        return "syntax.png";
                    }
                    case "Erro de lógica" -> {
                        return "logic.png";
                    }
                    case "Exception" -> {
                        return "exception.png";
                    }
                    case "File Not Found Exception" -> {
                        return "file-not-found-exception.png";
                    }
                    case "Crash (aka Rebentanço)" -> {
                        return "crash.png";
                    }
                    case "Duplicated Code" -> {
                        return "duplicated-code.png";
                    }
                    case "Efeitos secundários" -> {
                        return "secondary-effects.png";
                    }
                    case "Blue Screen of Death" -> {
                        return "bsod.png";
                    }
                    case "Ciclo infinito" -> {
                        return "infinite-loop.png";
                    }
                    case "Segmentation Fault" -> {
                        return "core-dumped.png";
                    }
                }

            }
        }

        return null;

    }

    public List<Programmer> getProgrammers(boolean includeDefeated) {
        if (includeDefeated) {
            return programmers;
        } else {
            List<Programmer> resProgrammers = new ArrayList<>();
            for (Programmer programmer : programmers) {
                if (!programmer.isDefeated()) {
                    resProgrammers.add(programmer);
                }
            }
            return resProgrammers;
        }
    }

    public List<Programmer> getProgrammers(int position) {
        if (!(boardMap.containsKey(position))) {
            return null;
        }

        if(boardMap.get(position).getProgrammers().isEmpty()){
            return null;
        }

        return boardMap.get(position).getProgrammers();
    }

    public int getCurrentPlayerID() {
        return head.programmer.getId();
    }

    public Programmer getCurrentPlayer(){
        return currentPlayer;
    }

    public boolean moveCurrentPlayer(int nrSpaces) {
        if (nrSpaces < 1 || nrSpaces > 6) {
            return false;
        }

        dado = nrSpaces;
        currentPlayer = head.programmer;

        if (!currentPlayer.getLoop()) {
            if (boardMap.get(currentPlayer.getPos()) != null) {
                boardMap.get(currentPlayer.getPos()).removeProgrammer(currentPlayer);
                currentPlayer.movePlayer(nrSpaces, boardMap.size());
                boardMap.get(currentPlayer.getPos()).addProgrammer(currentPlayer);
            }
            return true;
        }

        return false;

    }

    public void nextNode() {
        nrTurnos += 1;
        head = head.next;
        tail = tail.next;

    }

    public String reactToAbyssOrTool() {
        int count = 0;
        String res = null;

        if(boardMap.containsKey(currentPlayer.getPos()) && !currentPlayer.isDefeated()){
            res = boardMap.get(currentPlayer.getPos()).react(currentPlayer, dado, boardMap);
        }
        if(currentPlayer.isDefeated()){
            head = head.next;
            tail.next = null;
            tail.next = head;
            count++;
            nrTurnos++;
        }
        if(count == 0) {
            nextNode();
        }

        return res;
    }

    public Programmer getWinner(){
        for(Programmer programmer : programmers){
            if(!programmer.isDefeated()){
                return programmer;
            }
        }
        return null;
    }

    public boolean gameIsOver() {
        int countGameOver = 0;
        for(Programmer programmer : programmers){
            if(programmer.isDefeated()){
                countGameOver++;
            }
        }
        if (boardMap.get(boardMap.size()) != null) {
            if(countGameOver == programmers.size() - 1) {
                return true;
            }else if(!boardMap.get(boardMap.size()).getProgrammers().isEmpty()){
                Programmer programmerSave = boardMap.get(boardMap.size()).getProgrammers().get(0);
                programmers.remove(boardMap.get(boardMap.size()).getProgrammers().get(0));
                for(Programmer programmer : programmers){
                    programmer.gotDefeated();
                }
                programmers.add(programmerSave);
                return true;

            }
        }
        return false;
    }

    public List<String> getGameResults() {

        List<String> results = new ArrayList<>();
        List<Programmer> programmers = new ArrayList<>();
        for(int x = boardMap.size() ; x > 0 ; x--) {
            if(getProgrammers(x) != null) {
                programmers.addAll(getProgrammers(x));
            }
        }
        Programmer programmerSave = getWinner();
        programmers.remove(getWinner());
        results.add("O GRANDE JOGO DO DEISI");
        results.add("");
        results.add("NR. DE TURNOS");
        results.add("" + nrTurnos);
        results.add("");
        results.add("VENCEDOR");
        results.add(programmerSave.getName());
        results.add("");
        results.add("RESTANTES");
        for (Programmer programmer : programmers) {
            results.add(programmer.getName() + " " + programmer.getPos());
        }
        programmers.add(programmerSave);
        return results;
    }

    public JPanel getAuthorsPanel() {

        JPanel panel = new JPanel();

        JLabel jlabel1 = new JLabel("Inês Marques - a22001936");
        JLabel jlabel2 = new JLabel("Robert Cachapa - a22006023");

        panel.setBounds(40, 80, 200, 200);
        panel.setBackground(Color.white);

        panel.add(jlabel1);
        panel.add(jlabel2);

        return panel;

    }

    public String getTitle(int position) {

        if (boardMap.containsKey(position)) {
            return boardMap.get(position).getTitle();
        }
        return null;

    }

    public String getProgrammersInfo() {
        StringBuilder res = new StringBuilder();
        int programmersSize = programmers.size();
        int i = 0;
        for (Programmer programmer : programmers) {
            if (!programmer.isDefeated()) {

                res.append(programmer.getName()).append(" : ");
                res.append(programmer.getStringTools());

                i++;
                if (programmersSize == i) {
                    return res.toString();
                }
                res.append(" | ");
            }else {
                i++;
            }

        }
        return res.toString();
    }
}