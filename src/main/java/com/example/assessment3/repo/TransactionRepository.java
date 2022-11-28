package com.example.assessment3.repo;




import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.example.assessment3.dto.StatementResponseDto;
import com.example.assessment3.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
	@Query("SELECT date FROM Transaction where year(date)=?2 and month(date)=?1")
	List<LocalDate> Date(int month,int year);
	
	
	List<Transaction> findByDateAndToaccount(LocalDate date,long toaccount);
	
	
	List<Transaction> findByDateAndFromaccount(LocalDate date,long fromaccount);
	
	@Modifying
	@Query("SELECT  new  com.example.assessment3.dto.StatementResponseDto(amount,date,fromaccount) from Transaction where toaccount=:toaccount and date=:date")
	List<StatementResponseDto> findByDateAndToaccount1(long toaccount,LocalDate date);
	

	@Modifying
	@Query("SELECT  new  com.example.assessment3.dto.StatementResponseDto(amount,date,toaccount) from Transaction where fromaccount=:fromaccount and date=:date")
	List<StatementResponseDto> findByDateAndFromaccount1(long fromaccount,LocalDate date);
	
	

}
