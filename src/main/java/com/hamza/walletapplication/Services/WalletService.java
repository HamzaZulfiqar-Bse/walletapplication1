package com.hamza.walletapplication.Services;

import com.hamza.walletapplication.Entity.Wallet;
import com.hamza.walletapplication.Exception.WalletException;
import com.hamza.walletapplication.Repository.WalletRepository;
import com.hamza.walletapplication.WalletapplicationApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;
    public List<Wallet> getAll(){
        return walletRepository.findAllByOrOrderByPriority();
    }
    public Wallet getById(Long id){
        Optional<Wallet> wallet = walletRepository.findById(id);
        if (wallet.isPresent()){
            return wallet.get();
        }
        throw new WalletException("wallet with" +id+ " doesnot exist");



    }
    public Wallet createOrUpdate(Wallet wallet){
      if (wallet.getId() == null){
         walletRepository.save(wallet);

      }else {
          walletRepository.save(wallet);
      }
      return wallet;
    }
    public boolean Delete(Long id){
        Optional<Wallet> wallet = walletRepository.findById(id);
        if (wallet.isPresent()){
            walletRepository.delete(wallet.get());
            return true;
        }
        throw new WalletException("wallet with" +id+ " doesnot exist");

    }
}
