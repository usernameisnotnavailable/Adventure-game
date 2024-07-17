import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game {
    Board board;
    private final Player player;
    private final List<Boss> bosses;
    private final Locator locator;
    private List<AISpell> aiSpells;

    public Game(Player player, Board board, List<Boss> bosses) {
        this.player = player;
        this.board = board;
        this.bosses = bosses;
        this.locator = new Locator(player);
    }

    private ScheduledExecutorService playerExecutor;
    private ScheduledExecutorService computerExecutor;
    private ScheduledExecutorService paintExecutor;
    private boolean isRunning = true;

    public void run() {
        playerExecutor = Executors.newScheduledThreadPool(1);
        computerExecutor = Executors.newScheduledThreadPool(2);
        paintExecutor = Executors.newScheduledThreadPool(1);
        paintExecutor.scheduleAtFixedRate(this::paintElements, 0, 512, TimeUnit.MILLISECONDS);
        playerExecutor.scheduleAtFixedRate(this::updatePlayer, 0, 16, TimeUnit.MILLISECONDS);
        computerExecutor.scheduleAtFixedRate(this::updateComputerMove, 0, 512, TimeUnit.MILLISECONDS);
        computerExecutor.scheduleAtFixedRate(this::updateComputerAction, 256, 512, TimeUnit.MILLISECONDS);
    }

    private void paintElements() {
        board.boardRepaint();
    }

    private void updatePlayer() {
        Move.move(player.getDirection(), player);
        player.setDirection(0);
    }

    public void updateComputerMove() {
        bosses.forEach(locator::located);
        bosses.forEach(AIMove::aiMove);
    }

    private void updateComputerAction() {
        bosses.forEach(boss -> {
            if (boss.located()) {
                new AISpell(board, boss, player);
            }
        });
    }

    public void stop() {
        isRunning = false;
        playerExecutor.shutdown();
    }
}
