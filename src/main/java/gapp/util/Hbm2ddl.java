package gapp.util;

import java.util.HashMap;

import org.hibernate.cfg.Configuration;
//import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


@SuppressWarnings("deprecation")
public class Hbm2ddl {

    public static void main( String args[] )
    {
        if( args.length == 0 )
        {
            System.err.println( "java Hbm2ddl <outputFile>" );
            return;
        }

        System.out.print( "Export DDL to " + args[0] + " ... " );

        Configuration cfg = (new Ejb3Configuration()).configure( "gapp",
            new HashMap<String, Object>() ).getHibernateConfiguration();

        SchemaExport schemaExport = new SchemaExport( cfg );
        schemaExport.setOutputFile( args[0] )
            .setDelimiter( ";" )
            .setFormat( true )
            .setHaltOnError( true );

       
        schemaExport.execute( true, false, false, true );

        System.out.println( "Done." );
    }

}