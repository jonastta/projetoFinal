package pt.ipg.projetofinal

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TestBaseDados {
    private fun getAppContext() = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun apagaBaseDados(){
        getAppContext().deleteDatabase(BDGarrafeiraOpenHelper.NOME_BASE_DADOS)
    }

    @Test
    fun consegueAbrirBaseDados(){
        val dbOpenHelper = BDGarrafeiraOpenHelper(getAppContext())
        val db = dbOpenHelper.readableDatabase
        assert(db.isOpen)
        db.close()
    }
}