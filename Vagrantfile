Vagrant.configure(VAGRANT_API_VERSION = 2) do |config|
  config.vm.box = 'ubuntu/xenial64'
  config.vm.box_check_update = false

  config.ssh.forward_agent = true

  config.vm.network 'private_network', type: 'dhcp'

  config.vm.synced_folder '.', '/vagrant', type: 'nfs'

  config.vm.provider 'virtualbox' do |vb|
    vb.memory = '2048'
  end

  config.vm.provision 'ansible_local' do |ansible|
    ansible.playbook = 'cm/vagrant.yml'
    ansible.tags = ENV['TAGS']
  end
end
