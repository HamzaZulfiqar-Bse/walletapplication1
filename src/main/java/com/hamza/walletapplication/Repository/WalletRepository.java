package com.hamza.walletapplication.Repository;


import com.hamza.walletapplication.Entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    List<Wallet> findAllByOrOrderByPriority();

}
