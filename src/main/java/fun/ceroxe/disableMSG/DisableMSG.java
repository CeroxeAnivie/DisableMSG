package fun.ceroxe.disableMSG;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public final class DisableMSG extends JavaPlugin implements Listener, CommandExecutor {

    private boolean disableJoinQuit;
    private boolean disableAdvancements;

    @Override
    public void onEnable() {
        // 保存默认配置
        saveDefaultConfig();
        // 加载配置
        reloadPluginConfig();
        // 注册事件监听器
        getServer().getPluginManager().registerEvents(this, this);
        // 注册命令
        getCommand("dm").setExecutor(this);
        // 控制台提示
        getLogger().info("DisableMSG 插件已启用！");
    }

    private void reloadPluginConfig() {
        reloadConfig();
        FileConfiguration config = getConfig();
        // 从配置读取设置
        disableJoinQuit = config.getBoolean("disable-join-quit-message", true);
        disableAdvancements = config.getBoolean("disable-advancement-broadcast", true);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (disableJoinQuit) {
            event.setJoinMessage(null); // 取消加入消息
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (disableJoinQuit) {
            event.setQuitMessage(null); // 取消退出消息
        }
    }

    @EventHandler
    public void onAdvancement(PlayerAdvancementDoneEvent event) {
        if (disableAdvancements) {
            event.message(null); // 取消成就广播
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("disablemsg.reload")) {
                sender.sendMessage("§c你没有权限执行此命令！");
                return true;
            }
            reloadPluginConfig();
            sender.sendMessage("§aDisableMSG 配置已重载！");
            return true;
        }
        sender.sendMessage("§e使用方式: §f/dm reload");
        return true;
    }
}