package com.example.projectdanp.data;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EntryDao_Impl implements EntryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Entry> __insertionAdapterOfEntry;

  private final EntityInsertionAdapter<Entry> __insertionAdapterOfEntry_1;

  private final EntityDeletionOrUpdateAdapter<Entry> __updateAdapterOfEntry;

  private final SharedSQLiteStatement __preparedStmtOfDeleteEntryById;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllEntries;

  public EntryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEntry = new EntityInsertionAdapter<Entry>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `entry_table` (`id`,`day`,`month`,`year`,`amount`,`isIncome`,`description`,`currency`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Entry value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getDay());
        stmt.bindLong(3, value.getMonth());
        stmt.bindLong(4, value.getYear());
        stmt.bindDouble(5, value.getAmount());
        final int _tmp = value.isIncome() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        if (value.getDescription() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDescription());
        }
        if (value.getCurrency() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCurrency());
        }
      }
    };
    this.__insertionAdapterOfEntry_1 = new EntityInsertionAdapter<Entry>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `entry_table` (`id`,`day`,`month`,`year`,`amount`,`isIncome`,`description`,`currency`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Entry value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getDay());
        stmt.bindLong(3, value.getMonth());
        stmt.bindLong(4, value.getYear());
        stmt.bindDouble(5, value.getAmount());
        final int _tmp = value.isIncome() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        if (value.getDescription() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDescription());
        }
        if (value.getCurrency() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCurrency());
        }
      }
    };
    this.__updateAdapterOfEntry = new EntityDeletionOrUpdateAdapter<Entry>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `entry_table` SET `id` = ?,`day` = ?,`month` = ?,`year` = ?,`amount` = ?,`isIncome` = ?,`description` = ?,`currency` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Entry value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getDay());
        stmt.bindLong(3, value.getMonth());
        stmt.bindLong(4, value.getYear());
        stmt.bindDouble(5, value.getAmount());
        final int _tmp = value.isIncome() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        if (value.getDescription() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDescription());
        }
        if (value.getCurrency() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCurrency());
        }
        stmt.bindLong(9, value.getId());
      }
    };
    this.__preparedStmtOfDeleteEntryById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM entry_table where id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllEntries = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM entry_table";
        return _query;
      }
    };
  }

  @Override
  public Object addEntry(final Entry entry, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEntry.insert(entry);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insertEntry(final Entry entry, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEntry_1.insert(entry);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateEntry(final Entry entity, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfEntry.handle(entity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteEntryById(final int id, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteEntryById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteEntryById.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteAllEntries(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllEntries.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllEntries.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<Entry>> readAllData() {
    final String _sql = "SELECT * from entry_table ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"entry_table"}, false, new Callable<List<Entry>>() {
      @Override
      public List<Entry> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
          final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfIsIncome = CursorUtil.getColumnIndexOrThrow(_cursor, "isIncome");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCurrency = CursorUtil.getColumnIndexOrThrow(_cursor, "currency");
          final List<Entry> _result = new ArrayList<Entry>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Entry _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpDay;
            _tmpDay = _cursor.getInt(_cursorIndexOfDay);
            final int _tmpMonth;
            _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
            final int _tmpYear;
            _tmpYear = _cursor.getInt(_cursorIndexOfYear);
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final boolean _tmpIsIncome;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsIncome);
            _tmpIsIncome = _tmp != 0;
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCurrency;
            if (_cursor.isNull(_cursorIndexOfCurrency)) {
              _tmpCurrency = null;
            } else {
              _tmpCurrency = _cursor.getString(_cursorIndexOfCurrency);
            }
            _item = new Entry(_tmpId,_tmpDay,_tmpMonth,_tmpYear,_tmpAmount,_tmpIsIncome,_tmpDescription,_tmpCurrency);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<Entry> findEntry(final String search) {
    final String _sql = "SELECT * FROM entry_table WHERE amount LIKE ? or description LIKE ? or currency LIKE ? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (search == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, search);
    }
    _argIndex = 2;
    if (search == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, search);
    }
    _argIndex = 3;
    if (search == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, search);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfIsIncome = CursorUtil.getColumnIndexOrThrow(_cursor, "isIncome");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfCurrency = CursorUtil.getColumnIndexOrThrow(_cursor, "currency");
      final List<Entry> _result = new ArrayList<Entry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Entry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpDay;
        _tmpDay = _cursor.getInt(_cursorIndexOfDay);
        final int _tmpMonth;
        _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final double _tmpAmount;
        _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
        final boolean _tmpIsIncome;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsIncome);
        _tmpIsIncome = _tmp != 0;
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpCurrency;
        if (_cursor.isNull(_cursorIndexOfCurrency)) {
          _tmpCurrency = null;
        } else {
          _tmpCurrency = _cursor.getString(_cursorIndexOfCurrency);
        }
        _item = new Entry(_tmpId,_tmpDay,_tmpMonth,_tmpYear,_tmpAmount,_tmpIsIncome,_tmpDescription,_tmpCurrency);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Entry findOneEntry(final int id) {
    final String _sql = "SELECT * FROM entry_table WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
      final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfIsIncome = CursorUtil.getColumnIndexOrThrow(_cursor, "isIncome");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfCurrency = CursorUtil.getColumnIndexOrThrow(_cursor, "currency");
      final Entry _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final int _tmpDay;
        _tmpDay = _cursor.getInt(_cursorIndexOfDay);
        final int _tmpMonth;
        _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final double _tmpAmount;
        _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
        final boolean _tmpIsIncome;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsIncome);
        _tmpIsIncome = _tmp != 0;
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpCurrency;
        if (_cursor.isNull(_cursorIndexOfCurrency)) {
          _tmpCurrency = null;
        } else {
          _tmpCurrency = _cursor.getString(_cursorIndexOfCurrency);
        }
        _result = new Entry(_tmpId,_tmpDay,_tmpMonth,_tmpYear,_tmpAmount,_tmpIsIncome,_tmpDescription,_tmpCurrency);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
