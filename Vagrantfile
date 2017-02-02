
Vagrant.configure(2) do |config|
 
  config.vm.box = "wk8/ubuntu-14.04"

  config.ssh.username = "vagrant"
  config.ssh.password = "vagrant"
  # config.vm.network "private_network", ip: "192.168.33.10"

  # config.vm.synced_folder "../data", "/vagrant_data"

 
  config.vm.provider "virtualbox" do |vb| 
     vb.gui = false
     vb.memory = "1024"
  end


  config.vm.provision :shell, path: "vagrant-scripts/provision.sh"
   
end
