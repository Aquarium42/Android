package tasks;

import java.util.Stack;

/**
 * Напишите свой класс StringBuilder с поддержкой операции undo.
 *  Для этого делегируйте все методы стандартному StringBuilder,
 *   а в собственном классе храните список всех операций для выполнения undo().
 *    Это будет реализацией шаблона «Команда».
 * https://habr.com/ru/post/440436/#61
 */
public class Task06 {
	private interface Action{
        void undo();
    }

    private class DeleteAction implements Action{
        private int size;

        public DeleteAction(int size) {
            this.size = size;
        }

        public void undo(){
            stringBuilder.delete(
                stringBuilder.length() - size, stringBuilder.length());
        }
    }

    private StringBuilder stringBuilder;
    /* операции, обратные к выполненным. */
    private Stack<Action> actions = new Stack<>();

    public Task06() {
        stringBuilder = new StringBuilder();
    }

    public Task06 reverse() {
        stringBuilder.reverse();

        Action action = new Action(){
            public void undo() {
                stringBuilder.reverse();
            }
        };

        actions.add(action);

        return this;
    }


    public Task06 append(String str) {
        stringBuilder.append(str);

        Action action = new Action(){
            public void undo() {
                stringBuilder.delete(
                        stringBuilder.length() - str.length() -1,
                        stringBuilder.length());
            }
        };

        actions.add(action);
        return this;
    }

    // ..... остальные перегруженые методы append пишутся аналогично 

    public Task06 appendCodePoint(int codePoint) {
        int lenghtBefore = stringBuilder.length();
        stringBuilder.appendCodePoint(codePoint);
        actions.add(new DeleteAction(stringBuilder.length() - lenghtBefore));
        return this;
    }

    public Task06 delete(int start, int end) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        actions.add(() -> stringBuilder.insert(start, deleted));
        return this;
    }

    public Task06 deleteCharAt(int index) {
        char deleted = stringBuilder.charAt(index);
        stringBuilder.deleteCharAt(index);
        actions.add(() -> stringBuilder.insert(index, deleted));
        return this;
    }

    public Task06 replace(int start, int end, String str) {
        String deleted = stringBuilder.substring(start, end);
        stringBuilder.replace(start, end, str);
        actions.add(() -> stringBuilder.replace(start, end, deleted));
        return this;
    }

    public Task06 insert(int index, char[] str, int offset, int len) {
        stringBuilder.insert(index, str, offset, len);
        actions.add(() -> stringBuilder.delete(index, len));
        return this;
    }

    public Task06 insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        actions.add(() -> stringBuilder.delete(offset, str.length()));
        return this;
    }

    // ..... остальные перегруженные методы insert пишутся аналогично 

    public void undo(){
        if(!actions.isEmpty()){
            actions.pop().undo();
        }
    }

    public String toString() {
        return stringBuilder.toString();
    }
}
