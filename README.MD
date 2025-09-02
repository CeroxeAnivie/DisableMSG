# DisableMSG - Minecraft服务器消息禁用插件

![Minecraft](https://img.shields.io/badge/Minecraft-1.20.1-green)
![License](https://img.shields.io/badge/License-MIT-blue)
![Status](https://img.shields.io/badge/Status-Stable-brightgreen)

DisableMSG是一个轻量级的Paper插件，用于禁用Minecraft服务器的玩家加入/退出消息和成就广播系统。通过简单的配置文件即可灵活调整服务器消息设置。
你没看错，这个插件的功能就是那么简单

## 功能特性

- ✅ 禁用玩家加入服务器消息
- ✅ 禁用玩家退出服务器消息
- ✅ 禁用成就系统全局广播
- ⚙️ 配置文件实时控制功能开关
- 🔄 支持 `/dm reload` 命令热重载配置
- 🔐 完善的权限管理系统

## 安装方法

1. 下载最新版本的 [DisableMSG.jar](https://example.com/download)
2. 将JAR文件放入服务器的 `plugins/` 目录
3. 重启服务器
4. 配置文件将自动生成在 `plugins/DisableMSG/config.yml`

## 配置文件说明

```yaml
# config.yml 示例

# 是否禁用玩家加入/退出消息 (true: 禁用, false: 启用)
disable-join-quit-message: true

# 是否禁用成就系统广播 (true: 禁用, false: 启用)
disable-advancement-broadcast: true
```