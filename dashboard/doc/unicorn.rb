# -*- encoding: utf-8 -*-

root_path = File.expand_path '../', File.dirname(__FILE__)
# 日志
log_file = root_path + '/log/unicorn.log'
err_log  = root_path + '/log/unicorn_error.log'
# 进程标识
pid_file = '/tmp/unicorn_padrino.pid'
old_pid = pid_file + '.oldbin'
# 通道
socket_file = '/tmp/unicorn_padrino.sock'

worker_processes 6
working_directory root_path
timeout 30
# 侦听
listen 8080, tcp_nopush: false
listen socket_file, backlog: 1024

pid pid_file
stderr_path err_log
stdout_path log_file

preload_app true

before_exec do |server|
  ENV['BUNDLE_GEMFILE'] = root_path + '/Gemfile'
end

before_fork do |server, worker|
  if File.exists?(old_pid) && server.pid != old_pid
    begin
      Process.kill('QUIT', File.read(old_pid).to_i)
    rescue Errno::ENOENT, Errno::ESRCH
      puts "Send 'QUIT' signal to unicorn error!"
    end
  end
  end
